package sirok8;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JewelStones2Test {

    @Test
    public void testNumJewelsInStones() {
        // Тест 1: Основний випадок
        assertEquals(3, JewelStones.numJewelsInStones("aA", "aAAbbbb"));

        // Тест 2: Камені, яких немає серед коштовних
        assertEquals(0, JewelStones.numJewelsInStones("z", "ZZ"));

        // Тест 3: Всі камені коштовні
        assertEquals(4, JewelStones.numJewelsInStones("aA", "aAAa"));

        // Тест 4: Порожній рядок stones
        assertEquals(0, JewelStones.numJewelsInStones("aA", ""));

        // Тест 5: Порожній рядок jewels
        assertEquals(0, JewelStones.numJewelsInStones("", "aAAbbbb"));

        // Тест 6: Великі рядки
        assertEquals(1000, JewelStones.numJewelsInStones("ab", "aabb".repeat(250)));
    }
}
