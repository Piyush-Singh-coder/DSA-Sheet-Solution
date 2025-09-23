package CopyRandomList;

import java.util.*;

public class CopyRandomList {
    static class Node{
        int val;
        Node random;
        Node next;
        
        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node optimal(Node head){
        Map<Node,Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            oldToCopy.put(curr,copy);
            curr = curr.next;
        }
        curr = head;
        while(curr != head){
            Node copy = oldToCopy.get(curr);
            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);
            curr = curr.next;
        }
        return oldToCopy.get(head);

    }
    public static void main(String[] args) {
        
    } 
}
