import java.util.*;

public class Main {
    public static void main(String[] args) {

        String a = "ff";
        String b = new String("ff").intern();
        System.err.println(a == b);

        StringBuilder s = new StringBuilder();
        s.append("1");
        s.deleteCharAt(s.length() - 1);
        System.out.println(s.toString());

        int[] nums = {1,2,3,4};
        

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int res = 0;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//
//        }
    }
}


//import java.util.*;
//public class Main{
//
//    public static void main(String[] args){
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            String strings[]=scanner.nextLine().split(" ");
//            int sum=0;
//            for(String s:strings){
//                sum+=Integer.parseInt(s);
//            }
//            System.out.println(sum);
//        }
//    }
//}

//import java.util.Scanner;
//        import java.util.Arrays;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while(sc.hasNextLine()){
//            String str = sc.nextLine();
//            String[] strs = str.split(" ");
//            Arrays.sort(strs);
//            for(int i = 0; i < strs.length; ++i){
//                System.out.print(strs[i]);
//                if(i < strs.length - 1){
//                    System.out.print(" ");
//                }
//            }
//        }
//    }
//}

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()) {
//            String[] s = sc.nextLine().split(",");
//            Arrays.sort(s);
//            for(int i = 0; i < s.length; i++) {
//                if(i != s.length-1) {
//                    System.out.print(s[i] + ",");
//                }else {
//                    System.out.println(s[i]);
//                }
//            }
//        }
//    }
//}