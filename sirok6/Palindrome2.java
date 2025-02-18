package sirok6;

public class Palindrome2 {
    public static boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        StringBuilder filteredStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredStr.append(Character.toLowerCase(c));
            }
        }

        // Check if the filtered string is the same forwards and backwards
        String filteredString = filteredStr.toString();
        String reversedString = filteredStr.reverse().toString();

        return filteredString.equals(reversedString);
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));  // Output: false
    }
}

