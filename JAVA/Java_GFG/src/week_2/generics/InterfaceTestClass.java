package week_2.generics;

import week_2.generics.GenericInterface;

public class InterfaceTestClass<K,V>  implements GenericInterface<K,V> {
    K k;
    V v;
    @Override
    public K func1(K k) {
        this.k=k;
        return k;
    }

    @Override
    public V func2(V v) {
        this.v=v;
        return v;
    }
}
