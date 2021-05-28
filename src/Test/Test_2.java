package Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test_2 {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3};
        Arrays.sort(nums, (a, b) ->(b - a));

        LinkedList<Integer> list = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        //CopyOnWriteArrayList
//        ConcurrentHashMap
//LinkedHashMap
        int n = 10;
        char[] a = String.valueOf(n).toCharArray();

        String q = "2";
        String w = "10";
        System.out.println(q.compareTo(w));

        int p = (int)Math.pow(2, 31) - 1;
        System.out.println(p);

    }
}

