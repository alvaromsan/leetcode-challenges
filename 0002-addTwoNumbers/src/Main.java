public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode sum_head = addTwoNumbers(l1,l2);

        while(sum_head != null) {
            System.out.print(sum_head.val);
            sum_head = sum_head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode sum_head = sum;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int current_value = 0;
            int digit_to_add;

            if(l1 != null) {
                current_value += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                current_value += l2.val;
                l2 = l2.next;
            }

            current_value += carry;
            if(current_value >= 10) {
                carry = current_value/10;
                digit_to_add = current_value % 10;
            } else {
                digit_to_add = current_value;
                carry = 0;
            }
            sum.next = new ListNode(digit_to_add);
            sum = sum.next;
        }

        return sum_head.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}