package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class test_823_1 {
    public static void main(String[] args) {
        Solution solution = new test_823_1().new Solution();
        int[] rounds = {1,3,1,2};
        int n = 4;
        List<Integer> res = solution.mostVisited(n, rounds);
    }

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int[101];//定义一个记录次数的数组，在出现的进行数值加一
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < rounds.length; i++){
            if(rounds[i] > rounds[i - 1]){
                for(int j = rounds[i-1]; j < rounds[i]; j++){
                    count[j]++;
                }
            }else{//也就是说，走到头再重新开始一轮
                for(int j = rounds[i-1]; j <= n; j++){
                    count[j]++;
                }
                for(int j = 1; j < rounds[i]; j++){
                    count[j]++;
                }
            }
        }
        count[rounds[rounds.length - 1]]++;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < count.length; i++){
            max = Math.max(max, count[i]);
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] == max){
                res.add(i);
            }
        }
        return res;
    }
}

}