package sirok13;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetShelter petShelter = new PetShelter();
        petShelter.loadPets(); // Завантажуємо дані про тварин при запуску

        while (true) {
            // Виводимо меню
            System.out.println("\nМеню:");
            System.out.println("1. Додати тварину (add pet)");
            System.out.println("2. Переглянути всіх тварин (show all)");
            System.out.println("3. Видалити тварину (take pet from shelter)");
            System.out.println("4. Вихід (exit)");

            // Запитуємо користувача
            System.out.print("\nВиберіть опцію: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    // Додати тварину
                    System.out.print("Введіть ім'я тварини: ");
                    String name = scanner.nextLine();
                    System.out.print("Введіть породу: ");
                    String breed = scanner.nextLine();
                    System.out.print("Введіть вік: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    petShelter.addPet(name, breed, age);
                    System.out.println("Тварину додано до притулку.");
                    break;

                case "2":
                    // Показати всіх тварин
                    petShelter.showPets();
                    break;

                case "3":
                    // Видалити тварину
                    petShelter.showPets();
                    System.out.print("Введіть номер тварини для видалення: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    petShelter.removePet(index);
                    break;

                case "4":
                    // Вихід
                    petShelter.savePets(); // Зберігаємо дані перед виходом
                    System.out.println("Дані збережено. До побачення!");
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }
}

