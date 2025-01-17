
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class qwer1 {
    // Method to reverse the linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Save the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move prev and current one step forward
            current = nextNode;
        }

        return prev; // prev will be the new head of the reversed list
    }

    // Helper method to convert an array to a linked list
    public static ListNode arrayToList(int[] arr) {
        if (arr.length == 0) return null; // Return null if the array is empty
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to convert a linked list back to an array
    public static int[] listToArray(ListNode head) {
        if (head == null) return new int[0]; // Return empty array if the list is null
        ListNode current = head;
        int size = 0;

        // Calculate the size of the linked list
        while (current != null) {
            size++;
            current = current.next;
        }

        int[] arr = new int[size];
        current = head;
        int i = 0;

        // Fill the array with values from the linked list
        while (current != null) {
            arr[i++] = current.val;
            current = current.next;
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case: Empty input list
        ListNode head = arrayToList(new int[]{}); // Empty array
        ListNode reversedHead = solution.reverseList(head); // Reverse the list
        int[] reversedArray = listToArray(reversedHead); // Convert the reversed list back to array

        // Print the result (Should be an empty array)
        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
    }
}

