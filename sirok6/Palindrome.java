package sirok6;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        // Видаляємо всі неалфавітні символи та перетворюємо на маленькі літери
        StringBuilder filteredStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredStr.append(Character.toLowerCase(c));
            }
        }

        // Перевіряємо, чи є рядок однаковим, якщо його прочитати зліва направо та справа наліво
        String filteredString = filteredStr.toString();
        String reversedString = filteredStr.reverse().toString();

        return filteredString.equals(reversedString);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));  // Виведе: true
    }
}
