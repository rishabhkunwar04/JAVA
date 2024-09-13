package week_2.streams;


import java.util.Arrays;
import  java.util.*;
import java.util.stream.Collectors;

public class Mystream{
        public static void main(String[] args) {

            List<Integer>mylist= Arrays.asList(1,2,3,4,5);
            List<Integer>squaredNum=mylist.stream().map(val->val*val).collect(Collectors.toList());
            System.out.println(squaredNum);
}
}

/*

map()
filter()
flatmap()
distinct()
peek()
reduce()
count()

 */