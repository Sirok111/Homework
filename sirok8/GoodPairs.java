package sirok8;

import java.util.HashMap;

public class GoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int goodPairs = 0;

        // Перебираємо масив
        for (int num : nums) {
            // Якщо це число вже зустрічалося раніше, додаємо кількість попередніх пар
            if (map.containsKey(num)) {
                goodPairs += map.get(num);
            }
            // Збільшуємо лічильник поточного числа
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return goodPairs;
    }
}

