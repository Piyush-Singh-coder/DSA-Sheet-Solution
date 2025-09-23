package MergeTwoSortedLL;

public class MergeLL {
    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node merge(Node list1, Node list2){
        Node temp = new Node(0);
        Node dummy = temp;
        while(list1 != null && list2 != null){
            if (list1.data < list2.data){
                dummy.next = list1;
                list1 = list1.next;
            }else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if(list1!= null){
            dummy.next = list1;
        }
        if(list2 != null){
            dummy.next = list2;
        }
        return temp.next;
    }
    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);
        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(5);
        Node temp = merge(list1, list2);
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
