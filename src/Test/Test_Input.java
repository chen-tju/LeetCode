package Test;

import java.util.Scanner;

public class Test_Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] res = new int[24];

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int l = sc.nextInt();
            int c = sc.nextInt();
            boolean flag = false;

            for(int j = a; j < l; j++){
                res[j] += c;
                if(res[j] > m) {
                    flag = true;
                }
            }
            if(flag){
                for(int j = a; j < l; j++){
                    res[j] -= c;
                }
            }
        }

        for(int i = 0; i < 24; i++){
            System.out.print(res[i] + " ");
        }
    }
}
