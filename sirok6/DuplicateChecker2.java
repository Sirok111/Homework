package sirok6;

import java.util.HashSet;

public class DuplicateChecker2 {
    public static boolean containsDuplicate(int[] nums) {
        // Create a set to store unique elements
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // If the number is already in the set, we have a duplicate
            if (seen.contains(num)) {
                return true;
            }
            // Otherwise, add the number to the set
            seen.add(num);
        }

        // If we reach here, there were no duplicates
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));  // Output: false
    }
}

