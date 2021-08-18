
import java.util.*;


public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @param m long长整型
     * @return long长整型一维数组
     */
    public long[] FarmerNN (int n, long m) {
        // write code here
        long[] res = new long[n];
        int i = 0;
        boolean flag = true;
        while(m > 0){
            while(m > 0 && flag){
                res[i++]++;
                m--;
                if(i == n - 1){
                    flag = false;
                }
            }

            while(m > 0 && !flag){
                res[i--]++;
                m--;
                if(i == 0){
                    flag = true;
                }
            }
        }
        return res;
    }
}


//    public long section (int[] a, int t) {
//        // write code here
//        long res = 0;
//        int i = 0, j = 0;
//        while(i < a.length && j < a.length){
//            if((a[i] ^ a[j]) != t){
//                j++;
//                res += j - i;
//            }else{
//                i = j;
//            }
//        }
//        return res;
//    }

//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] nums = new int[n];
//        for(int i = 0; i < n; i++){
//            nums[i] = sc.nextInt();
//        }
//
//        int[] pre = new int[n + 1];
//        for(int i = 1; i <= n; i++){
//            pre[i] = pre[i - 1] + nums[i - 1];
//        }
//
//        double[][] res = new double[n + 1][n + 1];
//        for(int i = 1; i <= n; i++){
//            for(int j = i - k; j >= 0; j--){
//                double avg = (double)pre[i] - pre[j] / (i - j);
//                if(avg > res[i][0]){
//                    res[i][0] = avg;
//                    res[i][1] = j;
//                    res[i][2] = i - 1;
//                }else if(avg == res[i][0]){
//                    if(i - j > res[i][2] - res[i][1] + 1){
//                        res[i][1] = j;
//                        res[i][2] = i - 1;
//                    }
//                }
//            }
//        }
//
//        int[] ret = new int[2];
//        double max = 0.0;
//        for(int i = 1; i <= n; i++){
//            if(res[i][0] > max){
//                max = res[i][0];
//                ret[0] = (int)res[i][1];
//                ret[1] = (int)res[i][2];
//            }else if(res[i][0] == max){
//                if(i - res[i][0] > ret[1] - ret[0] + 1){
//                    ret[0] = (int)res[i][1];
//                    ret[1] = (int)res[i][2];
//                }
//            }
//        }
//        for(int tmp : ret){
//            System.out.print(tmp + " ");
//        }
//
////        int[] res = new int[2];
////
////        int max = Integer.MIN_VALUE;
////        for(int i = k - 1; i < n; i++){
////            int sum = 0;
////            for(int j = 0; j < k; j++){
////                sum += nums[i - j];
////            }
////            if(sum > max){
////                max = sum;
////                res[0] = i - k + 1;
////                res[1] = i;
////            }
////        }
////        for(int tmp : res){
////            System.out.print(tmp + " ");
////        }
//    }
//}



//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = 4;
//        int t = 2;
//        int c = 2;
//        int[] nums = {1, 2, 3, 1};
//
//
//
//
////        int[] nums = new int[n];
////        for(int i = 0; i < n; i++){
////            nums[i] = sc.nextInt();
////        }
//
//        int res = 0;
//        int l = 0;
//        for(int r = 0; r < n; r++){
//            if(nums[r] <= t && nums[l] <= t){
//                if(r - l + 1 == c){
//                    res++;
//                    l++;
//                }
//            }else{
//                l = r;
//            }
//        }
//        //for(int i = 0; i <= n - c; i++){
//        //    boolean flag = true;
//        //    for(int j = i; j < i + c; j++){
//        //        if(nums[j] > t){
//        //            flag = false;
//        //        }
//        //    }
//        //    if(flag){
//        //        res++;
//        //    }
//        //}
//        System.out.println(res);
//    }
//}


//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String[] strs = sc.next().split(":");
//        int k = Integer.parseInt(strs[1]);
//        String[] s = strs[0].split(",");
//        int[] nums = new int[s.length];
//        for(int i = 0; i < s.length; i++){
//            nums[i] = Integer.parseInt(s[i]);
//        }
//        double res = helper(nums, k);
//
//
//        System.out.println(String.format("%.2f", res * 100) + "%");
//    }
//    public static double helper(int[] nums, int k){
//        int pre = 0;
//        double max = 0.0;
//        for(int i = 0; i < k; i++){
//            pre += nums[i];
//        }
//        for(int i = k; i < nums.length; i++){
//            int cur = nums[i] + pre - nums[i - 3];
//            max = Math.max(max, (double)(cur - pre) / pre);
//            pre = cur;
//        }
//        return max;
//    }
//}

//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] res = new int[2];
//        Deque<Integer> stack = new LinkedList<>();
//
//        while(sc.hasNext()){
//            String[] strs = sc.next().trim().split(" ");
//            int[] nums = new int[strs.length];
//            for(int i = 0; i < strs.length; i++){
//                nums[i] = Integer.parseInt(strs[i]);
//            }
//            for(int i = 1; i < nums.length; i++){
//                if(nums[i] < nums[i - 1]){
//                    res[0] = i;
//                }
//            }
//            for(int i = nums.length - 1; i > 0; i--){
//                if(nums[i] < nums[i - 1]){
//                    res[1] = i;
//                }
//            }
//
//            System.out.println(res[0] + " " + res[1]);
//        }
//
//    }
//}


//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int res = 0;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//
//        }
//    }
//}


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