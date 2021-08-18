package Test;

import java.util.Scanner;
/*
    前言：
        在一次笔试中，因为不会处理逗号的输入输出，把能得全分的最后没得分。
        属实令人生气。。。
 */

/*
    输入格式：
    100
    5,25,30,45,50
    50,200,180,225,200

    输出格式：
    605
 */

public class Test_Next {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

//        String[] strs = sc.next().split(",");// 这样能得到 1 2 3 输出
//        String[] strsp = sc.nextLine().split(",");//这样切出来的是个空的数组

        String[] wt = sc.next().split(",");
        String[] vt = sc.next().split(",");
        int[] w = new int[wt.length];
        int[] v = new int[vt.length];
        for(int i = 0; i < wt.length; i++){
            w[i] = Integer.parseInt(wt[i]);
            v[i] = Integer.parseInt(vt[i]);
        }
        int res = helper(w, v, c);
        System.out.println(res);
    }

    public static int helper(int[] w, int[] v, int c){
        int[] dp = new int[c + 1];

        for(int i = 0; i < w.length; i++){
            for(int j = c; j >= w[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        return dp[c];
    }
}
