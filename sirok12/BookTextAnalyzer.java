package sirok12;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class BookTextAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запитуємо у користувача назву книги
        System.out.print("Введіть назву книги для аналізу: ");
        String bookName = scanner.nextLine().trim();

        // Перевіряємо, чи існує файл з такою назвою у директорії src/
        String bookPath = "src/" + bookName;
        File bookFile = new File(bookPath);

        if (!bookFile.exists()) {
            System.out.println("Книга не знайдена в директорії.");
            return;
        }

        try {
            // Читаємо вміст файлу
            String content = new String(Files.readAllBytes(Paths.get(bookPath)), "UTF-8");

            // Отримуємо статистику
            Map<String, Integer> wordCountMap = countWords(content);

            // Отримуємо 10 найбільш популярних слів
            List<Map.Entry<String, Integer>> sortedWords = wordCountMap.entrySet().stream()
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Сортуємо за кількістю
                    .limit(10)
                    .collect(Collectors.toList());

            // Виводимо статистику в консоль
            System.out.println("\nНайбільш популярні слова (за кількістю):");
            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

            // Виводимо загальну кількість унікальних слів
            System.out.println("\nЗагальна кількість унікальних слів: " + wordCountMap.size());

            // Записуємо статистику у файл
            writeStatisticsToFile(bookName, wordCountMap, sortedWords);

        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    // Метод для підрахунку слів у тексті
    public static Map<String, Integer> countWords(String content) {
        // Перетворюємо текст на нижній регістр і розбиваємо на слова
        String[] words = content.toLowerCase().split("\\W+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Підраховуємо кількість кожного слова
        for (String word : words) {
            if (word.length() > 2) { // Слова повинні бути довші ніж 2 символи
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }

    // Метод для запису статистики у файл
    public static void writeStatisticsToFile(String bookName, Map<String, Integer> wordCountMap,
                                             List<Map.Entry<String, Integer>> sortedWords) {
        String fileName = "src/" + bookName.replaceAll("\\.txt$", "") + "_statistic.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Записуємо 10 найбільш популярних слів
            writer.write("Найбільш популярні слова:\n");
            for (Map.Entry<String, Integer> entry : sortedWords) {
                writer.write(entry.getKey() + " -> " + entry.getValue() + "\n");
            }

            // Записуємо загальну кількість унікальних слів
            writer.write("\nЗагальна кількість унікальних слів: " + wordCountMap.size() + "\n");
            System.out.println("\nСтатистика записана у файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при записі файлу: " + e.getMessage());
        }
    }
}
