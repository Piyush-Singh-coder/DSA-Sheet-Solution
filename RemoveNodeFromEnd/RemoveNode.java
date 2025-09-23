package RemoveNodeFromEnd;

public class RemoveNode {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode removeNode(ListNode head, int n){
        ListNode curr = head;
        int N = 0;
        while(curr != null){
            N++;
            curr = curr.next;
        }
        int removeNode = N-n;
        if (removeNode == 0){
            return head.next;
        }
        curr = head;
        for(int i = 0; i<N-1; i++){
            if ((i+1) == removeNode){
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return head;

    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        int n = 2;
        head = removeNode(head, n);
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
