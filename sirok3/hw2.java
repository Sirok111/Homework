package sirok3;

// Визначення структури для вузла списку
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class hw2 {
    // Метод для реверсування списку
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // збереження наступного вузла
            current.next = prev; // реверсування вказівника поточного вузла
            prev = current; // рухаємося вперед
            current = nextNode;
        }

        return prev; // prev тепер є новим головним вузлом
    }

    // Метод для перетворення масиву в список
    public static ListNode arrayToList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Метод для перетворення списку в масив
    public static int[] listToArray(ListNode head) {
        ListNode current = head;
        int size = 0;

        // Обчислюємо розмір списку
        while (current != null) {
            size++;
            current = current.next;
        }

        int[] arr = new int[size];
        current = head;
        int i = 0;

        // Заповнюємо масив
        while (current != null) {
            arr[i++] = current.val;
            current = current.next;
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Перетворюємо масив на список
        ListNode head = arrayToList(new int[]{1, 2});

        // Реверсуємо список
        ListNode reversedHead = solution.reverseList(head);

        // Перетворюємо реверсований список назад у масив
        int[] reversedArray = listToArray(reversedHead);

        // Виведення результату
        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
    }
}
