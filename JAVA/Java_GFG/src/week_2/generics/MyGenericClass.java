package week_2.generics;

public class MyGenericClass<T,K> {
    private T obj;
    private K obj2;
    MyGenericClass(T obj,K obj2){
        this.obj=obj;
        this.obj2=obj2;
    }
    public T getObj(){
        return this.obj;
    }
    public K getObj2(){
        return this.obj2;
    }
    static <V> void print(V v){
        System.out.println(v);
    }
}

class Demo{

    public static void main(String[] args) {

        MyGenericClass<String,Integer>strGc=new MyGenericClass<>("Rishabh",30);
        System.out.println(strGc.getObj());
//        MyGenericClass<List<Integer>> inttgc=new MyGenericClass<>(Arrays.asList(1));
//        System.out.println(inttgc.getObj());
        MyGenericClass.print(3.4);
    }

}
