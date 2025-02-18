package sirok8;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GoodPairsTest {

    @Test
    public void testNumIdenticalPairs() {
        // Тест 1: Приклад з вхідними даними {1, 2, 3, 1, 1, 3}
        assertEquals(4, GoodPairs.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));

        // Тест 2: Всі елементи різні
        assertEquals(0, GoodPairs.numIdenticalPairs(new int[]{1, 2, 3, 4}));

        // Тест 3: Всі елементи однакові
        assertEquals(6, GoodPairs.numIdenticalPairs(new int[]{1, 1, 1, 1, 1}));

        // Тест 4: Порожній масив
        assertEquals(0, GoodPairs.numIdenticalPairs(new int[]{}));

        // Тест 5: Один елемент
        assertEquals(0, GoodPairs.numIdenticalPairs(new int[]{1}));

        // Тест 6: Дублікати з різними індексами
        assertEquals(1, GoodPairs.numIdenticalPairs(new int[]{1, 1}));
    }
}

