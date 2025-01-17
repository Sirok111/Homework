import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class vpr4 {

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


    public static List<Integer> findUnique(List<Integer> numberList) {
        if (numberList == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return new ArrayList<>(new HashSet<>(numberList));
    }

    public static void calcOccurance(List<String> wordList) {
        if (wordList == null) {
            throw new IllegalArgumentException("wordList must not be null");
        }

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : wordList) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        wordCountMap.forEach((word, count) -> {
            System.out.println(word + ": " + count);
        });
    }

    public static void main(String[] args) {
        List<String> sampleList = List.of("apple", "banana", "apple", "cherry", "banana", "apple", "date", "cherry", "apple", "fig");
        String target = "apple";
        int result = countOccurance(sampleList, target);
        System.out.println("The word '" + target + "' appears " + result + " times in the list.");

        int[] sampleArray = {1, 2, 3, 4, 5};
        List<Integer> integerList = toList(sampleArray);
        System.out.println("Converted List: " + integerList);

        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5, 5, 6);
        List<Integer> uniqueNumbers = findUnique(numbers);
        System.out.println("Unique Numbers: " + uniqueNumbers);

        System.out.println("Word Occurrences:");
        calcOccurance(sampleList);
    }
}
