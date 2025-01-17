import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductDemo {

    // 1.2 Метод для отримання продуктів категорії "Book" з ціною більше 250
    public static List<Product> getBooksByPrice(@NotNull List<Product> products, double minPrice) {
        return products.stream()
                .filter(product -> "Book".equals(product.getType()) && product.getPrice() > minPrice)
                .collect(Collectors.toList());
    }

    // 2.2 Метод для отримання продуктів категорії "Book" з знижкою
    public static List<Product> getBooksWithDiscount(@NotNull List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getType()) && product.isDiscount())
                .map(product -> new Product(product.getType(), product.getPrice() * 0.9, product.isDiscount(), product.getCreateDate()))
                .collect(Collectors.toList());
    }

    // 3.2 Метод для отримання найдешевшого продукту категорії "Book"
    public static Product getCheapestBook(@NotNull List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getType()))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Продукт категорії Book не знайдено"));
    }

    // 4.2 Метод для отримання трьох останніх доданих продуктів
    public static List<Product> getLastThreeAddedProducts(@NotNull List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    // 5.2 Метод для обчислення загальної вартості продуктів, що відповідають критеріям
    public static double calculateTotalPrice(@NotNull List<Product> products) {
        return products.stream()
                .filter(product -> product.getCreateDate().getYear() == LocalDate.now().getYear())
                .filter(product -> "Book".equals(product.getType()))
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // 6.2 Метод для групування продуктів за типом
    public static Map<String, List<Product>> groupByType(@NotNull List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    public static void main(String[] args) {
        // Створення списку продуктів
        List<Product> products = Arrays.asList(
                new Product("Book", 300.0, true, LocalDate.of(2022, 1, 1)),
                new Product("Book", 150.0, true, LocalDate.of(2022, 1, 2)),
                new Product("Toy", 50.0, false, LocalDate.of(2023, 1, 10)),
                new Product("Book", 400.0, false, LocalDate.of(2022, 1, 3)),
                new Product("Toy", 80.0, true, LocalDate.of(2022, 5, 5)),
                new Product("Book", 250.0, true, LocalDate.of(2021, 1, 1))
        );

        // Виклик методів
        System.out.println("Books with price > 250:");
        getBooksByPrice(products, 250).forEach(System.out::println);

        System.out.println("\nBooks with discount applied:");
        getBooksWithDiscount(products).forEach(System.out::println);

        System.out.println("\nCheapest Book:");
        System.out.println(getCheapestBook(products));

        System.out.println("\nLast 3 Added Products:");
        getLastThreeAddedProducts(products).forEach(System.out::println);

        System.out.println("\nTotal Price of Books added this year (price <= 75):");
        System.out.println(calculateTotalPrice(products));

        System.out.println("\nGrouped Products by Type:");
        groupByType(products).forEach((type, productList) -> {
            System.out.println(type + ": " + productList);
        });
    }
}

