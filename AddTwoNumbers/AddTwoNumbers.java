package AddTwoNumbers;


public class AddTwoNumbers {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int ans = val1 + val2 + carry;
            carry = ans / 10;
            ans = ans %10;
            temp.next = new ListNode(ans);
            temp = temp.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }
    public static void main (String[] args){
        ListNode l1 = new ListNode(1, new ListNode(5, new ListNode(3, null)));
        ListNode l2 = new ListNode(4, new ListNode(5, new ListNode(6, null)));
        ListNode head = addTwoNumbers(l1, l2);
        while(head != null){
            System.out.print(head.val +"->");
            head = head.next;
        }
        System.out.println("null");
    }
}
