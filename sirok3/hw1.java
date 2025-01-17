class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class hw1 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    public static ListNode arrayToList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    public static int[] listToArray(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        int[] arr = new int[size];
        current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.val;
            current = current.next;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = arrayToList(new int[]{1, 2, 3, 4, 5});

        ListNode reversedHead = solution.reverseList(head);

        int[] reversedArray = listToArray(reversedHead);

        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
    }
}