package week_1.staticClass;

import java.util.HashMap;
import java.util.Map;

public class MyStaticClass {

    public static String name="Rishabh";

    /* static block concept
     1. as soon as the class initialized the static block members put in memory and initialized
     */
//    public static String lastname="Kunwar";
    public static String lastname;
    static {
        lastname="Kunwar";
    }
    public static Map<String, String> map=new HashMap<>();

    static {
        map.put("Bihar","Patna");
        map.put("Delhi","Delhi");
        map.put("Maharashtra","Mumbai");
    }

    public static int addNumber(int a,int b){
        return a+b;

    }
}
