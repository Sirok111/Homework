import java.util.Random;
import java.util.Scanner;

public class ddzz4 {

    public static int findSymbolOccurrence(String string, char symbol) {
        if (string == null) {
            throw new IllegalArgumentException("Рядок не може бути null.");
        }

        int count = 0;
        for (char c : string.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }
    public static int findWordPosition(String source, String target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Рядки не можуть бути null.");
        }

        return source.indexOf(target);
    }


    public static String stringReverse(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Рядок не може бути null.");
        }

        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Рядок не може бути null.");
        }

        String reversed = stringReverse(string);
        return string.equals(reversed);
    }

    public static void main(String[] args) {
        String exampleString = "hello world";
        char exampleSymbol = 'o';
        int result = findSymbolOccurrence(exampleString, exampleSymbol);
        System.out.println("Символ '" + exampleSymbol + "' зустрічається " + result + " разів у рядку '" + exampleString + "'.");
        String source = "Apollo";
        String target = "pollo";
        int position = findWordPosition(source, target);
        System.out.println("Підрядок '" + target + "' знаходиться на позиції " + position + " у рядку '" + source + "'.");

        source = "Apple";
        target = "Plant";
        position = findWordPosition(source, target);
        System.out.println("Підрядок '" + target + "' знаходиться на позиції " + position + " у рядку '" + source + "'.");

        String original = "Hello";
        String reversed = stringReverse(original);
        System.out.println("Рядок '" + original + "' у зворотному порядку: '" + reversed + "'.");

        String palindrome = "ERE";
        String nonPalindrome = "Allo";
        System.out.println("Рядок '" + palindrome + "' є паліндромом: " + isPalindrome(palindrome));
        System.out.println("Рядок '" + nonPalindrome + "' є паліндромом: " + isPalindrome(nonPalindrome));

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String secretWord = words[random.nextInt(words.length)];
        System.out.println("Комп'ютер загадав слово. Спробуйте його вгадати!");

        boolean guessed = false;
        while (!guessed) {
            System.out.print("Ваше слово: ");
            String userWord = scanner.nextLine().toLowerCase();

            if (userWord.equals(secretWord)) {
                guessed = true;
                System.out.println("Ви вгадали слово! Це було: " + secretWord);
            } else {
                StringBuilder hint = new StringBuilder();
                for (int i = 0; i < 15; i++) {
                    if (i < secretWord.length() && i < userWord.length() && secretWord.charAt(i) == userWord.charAt(i)) {
                        hint.append(secretWord.charAt(i));
                    } else {
                        hint.append('#');
                    }
                }
                System.out.println("Підказка: " + hint);
            }
        }

        scanner.close();
    }
}
