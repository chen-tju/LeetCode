//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 362 👎 0


package leetcode.editor.cn;

//第k个排列   ------回溯法，利用阶乘进行剪枝

public class P60_PermutationSequence{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P60_PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(3,3));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//利用计算到的阶乘数组进行剪枝操作
    public String getPermutation(int n, int k) {
        int[] fac = calFac(n);
        boolean[] used = new boolean[n + 1];
        //Arrays.fill(used, false);
        StringBuilder path = new StringBuilder();
        dfs(n, k, 0, fac, used, path);
        return path.toString();
    }

    private void dfs(int n, int k, int index, int[] fac, boolean[] used, StringBuilder path){
        if(index == n){
            return;
        }
        int cnt = fac[n - 1 - index];
        for(int i = 1; i <= n; i++){
            if(! used[i]){
                if(cnt < k){
                    k -= cnt;
                    continue;
                }
                path.append(i);
                used[i] = true;
                dfs(n, k, index + 1, fac, used, path);
                return; //这里不需要回溯
            }
        }

    }

    private int[] calFac(int n){
        int[] fac = new int[n + 1];
        fac[0] = 1;
        for(int i = 1; i <= n; i++){
            fac[i] = fac[i - 1] * i;
        }
        return fac;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}