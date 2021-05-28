package Test;

import java.util.LinkedList;

public class Test_Deque {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        System.out.println(stack);
        System.out.println(stack.pop());

        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.poll());

        System.out.println(stack);

        System.out.println("-------------分界线----------------");

        StringBuilder sb = new StringBuilder();
        sb.append("ij");
        sb.insert(1,"a");
        System.out.println(sb);
        sb.setLength(10);
        System.out.println(sb);
        sb.delete(2,3);
        System.out.println(sb);
        sb.deleteCharAt(1);
        System.out.println(sb);
        System.out.println(sb.capacity());

        sb.append("njn");
        System.out.println(sb);
        System.out.println(sb.indexOf("njn", 0));

        System.out.println(sb.reverse());
        int s = sb.indexOf("njn", 0);
        System.out.println(s);

        System.out.println(sb.length());
        sb.replace(5, 7,"ddddd");
        System.out.println(sb);
        System.out.println(sb.length());

        sb.replace(4, 7,"d");
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
