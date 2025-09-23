package LinkedList;

public class LinkedListCreation {
    class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
        static Node head;
        static Node tail;
        static int size = 0;

        public int size(){
            return size;
        }

        public void addFirst(int data){
            Node newNode = new Node(data);
            size++;
            if (head == null){
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public void addLast(int data){
            Node newNode = new Node(data);
            size++;
            if (head == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public void add(int index, int data){
            Node newNode = new Node(data);
            size++;
            if (index == 0){
                addFirst(data);
                return;
            }
            Node temp = head;
            int i = 0;
            while(i<index-1){
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        public void traverse(){
            if (head == null){
                System.out.println("LinkedList is empty");
                return;
            }
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
        public boolean isEmpty(){
            return head == null;
        }

        // Remove Methods
        public int removeFirst(){
            if (size == 0){
                System.out.println("Linked list is already empty");
                return -1;
            }
            if (size == 1){
                int val = head.data;
                head = tail = null;
                return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
        public int removeLast(){
            Node temp = head;
            int i = 0;
            while(i<size()-2){
                temp = temp.next;
                i++;
            }
            int val = tail.data;
            temp.next = null;
            tail = temp;
            return val;
        }
    public static void main(String[] args) {
        LinkedListCreation ll = new LinkedListCreation();
        ll.addFirst(12);
        ll.addLast(23);
        ll.addFirst(10);
        ll.add(1,11);
        System.out.println(ll.removeLast());
        System.out.println(ll.size());
        ll.traverse();
    }
}
