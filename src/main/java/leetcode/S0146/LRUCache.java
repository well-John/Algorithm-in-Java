package leetcode.S0146;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 */
public class LRUCache {

    class LinkedListNode {
        LinkedListNode pre;
        LinkedListNode next;
        int key;
        int val;

        LinkedListNode() {

        }

        LinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    private Map<Integer, LinkedListNode> cache = new HashMap<>();

    private int capacity;

    private int size;

    private LinkedListNode head;

    private LinkedListNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedListNode();
        tail = new LinkedListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(LinkedListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LinkedListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LinkedListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        LinkedListNode node = cache.get(key);
        if (node == null) {
            ++size;
            if (size > capacity) {
                LinkedListNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
            LinkedListNode newNode = new LinkedListNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }else {
            node.val = value;
            moveToHead(node);
        }
    }

    private LinkedListNode removeTail() {
        LinkedListNode res = tail.pre;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }

}
