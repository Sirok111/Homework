package sirok9;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Сервер запущено, очікуємо на підключення клієнта...");

            // Приймаємо підключення від клієнта
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                System.out.println("Клієнт підключився.");

                // Відправляємо привітання
                out.println("Привіт!");

                // Читаємо привітання від клієнта
                String clientMessage = in.readLine();
                System.out.println("Клієнт надіслав: " + clientMessage);

                // Перевірка на наявність російських літер
                if (containsRussianLetters(clientMessage)) {
                    out.println("Що таке паляниця?");
                    String clientResponse = in.readLine();
                    System.out.println("Клієнт відповів: " + clientResponse);

                    // Перевірка на правильну відповідь
                    if ("паляниця".equalsIgnoreCase(clientResponse)) {
                        out.println("Правильна відповідь!");
                        out.println("Поточна дата і час: " + getCurrentDateTime());
                        out.println("До побачення!");
                    } else {
                        out.println("Неправильна відповідь. Ви відключені.");
                    }
                } else {
                    out.println("Ваше привітання прийнято.");
                    out.println("До побачення!");
                }

            } catch (IOException e) {
                System.out.println("Помилка при обміні даними з клієнтом: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Не вдалося запустити сервер: " + e.getMessage());
        }
    }

    // Метод для перевірки наявності російських літер
    private static boolean containsRussianLetters(String text) {
        for (char c : text.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) {
                return true;
            }
        }
        return false;
    }

    // Метод для отримання поточної дати та часу
    private static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
