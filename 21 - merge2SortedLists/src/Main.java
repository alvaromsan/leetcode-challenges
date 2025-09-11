import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to MergeTwoSortedLists (type 'exit' to quit): ");
            System.out.print("First list of numbers separated by spaces: ");
            String line1 = input.nextLine();

            if (line1.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            String[] values1 = line1.trim().split("\\s+"); // split by spaces



            System.out.print("Second list of numbers separated by spaces: ");
            String line2 = input.nextLine();

            if (line2.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            String[] values2 = line2.trim().split("\\s+"); // split by spaces

            // Create the list1
            ListNode list1 = new ListNode(Integer.parseInt(values1[0]));
            ListNode head1 = list1;

            // Create remaining nodes directly
            for (int i = 1; i < values1.length; i++) {
                list1.next = new ListNode(Integer.parseInt(values1[i]));
                list1 = list1.next;
            }

            // Create the list2
            ListNode list2 = new ListNode(Integer.parseInt(values2[0]));
            ListNode head2 = list2;

            // Create remaining nodes directly
            for (int i = 1; i < values2.length; i++) {
                list2.next = new ListNode(Integer.parseInt(values2[i]));
                list2 = list2.next;
            }

            System.out.println("Original List1: " + head1);
            head1 = sortList(head1);
            System.out.println("Sorted List1: " + head1);
            System.out.println("Original List2: " + head2);
            head2 = sortList(head2);
            System.out.println("Sorted List2: " + head2);
            System.out.println("MergedList: " + mergeTwoLists(head1, head2));

        }

        input.close();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // Points the start of listNode, so we can return it at the end
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return dummy.next;
    }


    // Sorting for linked list
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Split list into two halves
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next; // this list will in the middle of the first list as we are jumping 2n2 (fast)
            fast = fast.next.next;
        }
        prev.next = null; // cut the list into two halves

        // Recursively sort both halves until we only have 1 number in the halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge sorted halves
        return mergeTwoLists(left, right);
    }
}