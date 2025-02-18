package sirok6;

public class Palindrome3 {
    public static boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        StringBuilder filteredStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredStr.append(Character.toLowerCase(c));
            }
        }

        // If the filtered string is empty or its reverse is the same as itself, it's a palindrome
        String filteredString = filteredStr.toString();
        String reversedString = filteredStr.reverse().toString();

        return filteredString.equals(reversedString);
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(isPalindrome(s));  // Output: true
    }
}

