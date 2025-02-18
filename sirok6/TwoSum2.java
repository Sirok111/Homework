package sirok6;

import java.util.HashMap;

public class TwoSum2 {
    public static int[] twoSum(int[] nums, int target) {
        // Create a map to store the number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];

            // If the complement is already in the map, we found the solution
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }

        // Since the problem guarantees one solution, we shouldn't reach here
        return new int[] {}; // Just a fallback
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");  // Output: [1, 2]
    }
}
