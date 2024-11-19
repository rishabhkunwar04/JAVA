package Design_questions.lruCache;

// generic type <K,V>
public class Node <K,V> {
     K Key;
     V Value;
     Node<K,V> next;
     Node<K,V> prev;


    public Node(K Key, V Value){
        this.Key=Key;
        this.Value=Value;
      //next=new Node<>(null,null);
      // prev=new Node<>(null,null);


    }

}
