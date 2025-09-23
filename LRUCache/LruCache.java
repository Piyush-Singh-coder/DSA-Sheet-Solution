package LRUCache;

import java.util.HashMap;

public class LruCache {
    static class ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val){
            this.key = key;
            this.val=val;
            this.prev = null;
            this.next = null;
        }
    }
    static class LRUCache{
        int capacity;
        HashMap<Integer, ListNode>cache;
        ListNode head;
        ListNode tail;

        public LRUCache(int capacity){
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = new ListNode(0,0);
            this.tail = new ListNode(0, 0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }
        private void remove(ListNode node){
            ListNode prev = node.prev;
            ListNode nxt = node.next;
            prev.next = nxt;
            nxt.prev = prev;
        }
        private void insert (ListNode node){
            ListNode prev = this.tail.prev;
            node.prev = prev;
            node.next = this.tail;
            this.tail.prev = node;
            prev.next = node;
        }
        public int get(int key){
            if (cache.containsKey(key)){
                ListNode node = cache.get(key);
                remove(node);
                insert(node);
                return node.val;
            }
            return -1;
        }
        public void put(int key, int val){
            if (cache.containsKey(key)){
                remove(cache.get(key));
            }
            ListNode newNode = new ListNode(key, val);
            cache.put(key, newNode);
            insert(newNode);
            if (cache.size() > capacity){
                ListNode lru = this.head.next;
                remove(lru);
                cache.remove(lru.key);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
