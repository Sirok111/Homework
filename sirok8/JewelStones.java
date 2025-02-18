package sirok8;

public class JewelStones {
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        // Перебираємо всі камені в stones
        for (char stone : stones.toCharArray()) {
            // Якщо камінь є в jewels, збільшуємо лічильник
            if (jewels.indexOf(stone) != -1) {
                count++;
            }
        }

        return count;
    }
}

