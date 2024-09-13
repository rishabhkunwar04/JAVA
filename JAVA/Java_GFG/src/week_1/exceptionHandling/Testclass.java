package week_1.exceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Testclass  {
    public static void main(String[] args)  throws FileNotFoundException {
//        int n=10;
//        int d=0;
//        int q;
//
//        try{
//            q=n/d;
//        }catch (RuntimeException e){
//            System.out.println("inside catch");
////            throw e;
//        }finally {
//            System.out.println("finally always gets executed");
//        }
        FileReader f=new FileReader("src/sample.txt"); // without throws keyword it will give compile time error

    }

}
