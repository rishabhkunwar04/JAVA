package Design_questions.lruCache;

import java.util.HashMap;
import java.util.Map;
//
public class  LruCache<K,V> {
    private int capacity;
    private Node<K,V> head;
    private Node<K,V> tail;
    private Map<K,Node<K,V>>cache;
    public LruCache(int capacity){
        this.capacity=capacity;
        cache=new HashMap<>(capacity);
        this.head=new Node<>(null,null);
        this.tail=new Node<>(null,null);
        head.next = tail;
        tail.prev = head;


    }
    public synchronized  V get(K Key){
        Node<K,V> node=cache.get(Key);
        if(node==null){
            return null;
        }
        moveToHead(node);
        return node.Value;

    }
    public synchronized void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            node.Value = value;
            moveToHead(node);
        } else {
            node = new Node<>(key, value);
            cache.put(key, node);
            addToHead(node);
            if (cache.size() > capacity) {
                Node<K, V> removedNode = removeTail();
                cache.remove(removedNode.Key);
            }
        }
    }
    public void addToHead(Node<K,V> node){
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }
    private Node<K, V> removeTail() {
        Node<K, V> node = tail;
        if (head == tail)
        {
            head = tail = null;
        }
        else
        {
            tail = tail.prev;
            tail.next = null;
        }
        return node;
    }
    public void moveToHead(Node<K,V> node){
        if (node == head) //if already on head
        {
            return;
        }
        if (node == tail) // if last then remove
        {
            tail = tail.prev;
            tail.next = null;
        }
        else
        {
            // delete in between
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        //add in head
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

}

