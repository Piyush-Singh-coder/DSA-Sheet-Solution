package ReverseNodeInKthGroup;

public class ReverseNodeKThGroup {
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
    public static ListNode recursionMethod(ListNode head, int k){
        ListNode temp = head;
        int count = 0;
        while(count <k){
            if (temp == null){
                return head;
            }
            temp = temp.next;
            count++;
        }
        ListNode prev = recursionMethod(temp, k);
        temp = head;
        count = 0;
        while(count < k && temp != null){
            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
            count++;
        }
        return prev;
    }
    public static ListNode getKthNode(ListNode head, int k){
        k -= 1;
        ListNode temp = head;
        while (temp != null && k < 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        int k = 2;
        ListNode temp = recursionMethod(head, k);
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
