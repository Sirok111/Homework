import java.util.List;

public class vpr1 {

    public static int countOccurance(List<String> wordList, String targetWord) {
        if (wordList == null || targetWord == null) {
            throw new IllegalArgumentException("wordList and targetWord must not be null");
        }

        int count = 0;
        for (String word : wordList) {
            if (targetWord.equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> sampleList = List.of("apple", "banana", "apple", "cherry", "banana", "apple", "date", "cherry", "apple", "fig");
        String target = "apple";
        int result = countOccurance(sampleList, target);
        System.out.println("The word '" + target + "' appears " + result + " times in the list.");
    }
}
