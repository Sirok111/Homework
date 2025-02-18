package sirok13;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetShelter{

    private List<Pet> pets = new ArrayList<>();
    private final String dataFile = "pets.json";

    // Завантажуємо тварин з файлу
    public void loadPets() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(dataFile);
            if (file.exists()) {
                pets = objectMapper.readValue(file, new TypeReference<List<Pet>>() {});
            }
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні даних: " + e.getMessage());
        }
    }

    // Зберігаємо тварин у файл
    public void savePets() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(dataFile), pets);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні даних: " + e.getMessage());
        }
    }

    // Додати тварину
    public void addPet(String name, String breed, int age) {
        pets.add(new Pet(name, breed, age));
    }

    // Показати всіх тварин
    public void showPets() {
        if (pets.isEmpty()) {
            System.out.println("У притулку немає тварин.");
        } else {
            System.out.println("\nСписок тварин у притулку:");
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }
    }

    // Видалити тварину
    public void removePet(int index) {
        if (index >= 0 && index < pets.size()) {
            pets.remove(index);
            System.out.println("Тварину видалено з притулку.");
        } else {
            System.out.println("Невірний індекс.");
        }
    }

    // Отримати список тварин
    public List<Pet> getPets() {
        return pets;
    }
}

