package MergeKSortedLL;

public class MergeKSorted {
    static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
        public Node (int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static Node mergeSorted(Node[] list){
        for(int i = 1; i<list.length; i++){
            list[i] = merge(list[i-1], list[i]);
        }
        return list[list.length-1];
    }
    public static Node merge(Node l1, Node l2){
        Node dummy = new Node(0);
        Node curr = dummy;

        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null){
            curr.next = l1;
        }
        else if (l2 != null){
            curr.next = l2;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Node [] list = new Node[3];
        list[0] = new Node(1,(new Node(2, new Node(4, null))));
        list[1] = new Node(1,(new Node(3, new Node(5, null))));
        list[2] = new Node(3,(new Node(6, null)));
        Node head = mergeSorted(list);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
