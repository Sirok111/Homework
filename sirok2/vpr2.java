import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class vpr2 {

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

    public static List<Integer> toList(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }
        return new ArrayList<>(Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new)));
    }

    public static void main(String[] args) {
        List<String> sampleList = List.of("apple", "banana", "apple", "cherry", "banana", "apple", "date", "cherry", "apple", "fig");
        String target = "apple";
        int result = countOccurance(sampleList, target);
        System.out.println("The word '" + target + "' appears " + result + " times in the list.");

        int[] sampleArray = {1, 2, 3, 4, 5};
        List<Integer> integerList = toList(sampleArray);
        System.out.println("Converted List: " + integerList);
    }
}
