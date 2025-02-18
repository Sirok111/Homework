package sirok11;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {

    private Queue<Order> ordersQueue;
    private int nextOrderNumber;

    // Конструктор
    public CoffeeOrderBoard() {
        ordersQueue = new LinkedList<>();
        nextOrderNumber = 1; // Початковий номер для замовлення
    }

    // Метод для додавання нового замовлення
    public void add(String name) {
        Order newOrder = new Order(nextOrderNumber, name);
        ordersQueue.add(newOrder);
        nextOrderNumber++; // Збільшуємо номер наступного замовлення
    }

    // Метод для видачі найближчого замовлення (з черги)
    public Order deliver() {
        if (!ordersQueue.isEmpty()) {
            return ordersQueue.poll(); // Видає та видаляє замовлення
        }
        return null; // Якщо черга порожня, повертає null
    }

    // Метод для видачі замовлення за певним номером
    public Order deliver(int orderNumber) {
        for (Order order : ordersQueue) {
            if (order.getOrderNumber() == orderNumber) {
                ordersQueue.remove(order);
                return order;
            }
        }
        return null; // Якщо замовлення не знайдено
    }

    // Метод для виведення поточного стану черги
    public void draw() {
        System.out.println("============= ");
        System.out.println("Num | Name");
        for (Order order : ordersQueue) {
            System.out.println(order.getOrderNumber() + " | " + order.getName());
        }
    }

    // Внутрішній клас для замовлення
    public static class Order {
        private int orderNumber;
        private String name;

        // Конструктор замовлення
        public Order(int orderNumber, String name) {
            this.orderNumber = orderNumber;
            this.name = name;
        }

        // Геттери
        public int getOrderNumber() {
            return orderNumber;
        }

        public String getName() {
            return name;
        }
    }

    // Основний метод для тестування
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        // Додавання замовлень
        coffeeOrderBoard.add("Alen");
        coffeeOrderBoard.add("Yoda");
        coffeeOrderBoard.add("Obi-van");
        coffeeOrderBoard.add("John Snow");

        // Виведення черги
        coffeeOrderBoard.draw();

        // Видача замовлення
        System.out.println("\nDelivering the first order:");
        Order deliveredOrder = coffeeOrderBoard.deliver();
        if (deliveredOrder != null) {
            System.out.println("Delivered: " + deliveredOrder.getOrderNumber() + " | " + deliveredOrder.getName());
        }

        // Виведення черги після видачі замовлення
        coffeeOrderBoard.draw();

        // Видача замовлення за номером
        System.out.println("\nDelivering order number 33:");
        deliveredOrder = coffeeOrderBoard.deliver(33);
        if (deliveredOrder != null) {
            System.out.println("Delivered: " + deliveredOrder.getOrderNumber() + " | " + deliveredOrder.getName());
        }

        // Виведення черги після видачі замовлення за номером
        coffeeOrderBoard.draw();
    }
}
