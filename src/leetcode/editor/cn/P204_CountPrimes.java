//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 663 👎 0


package leetcode.editor.cn;

//计数质数

import java.util.Arrays;

public class P204_CountPrimes{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P204_CountPrimes().new Solution();
        System.out.println(solution.countPrimes(499979));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        boolean[] check = new boolean[n];
        Arrays.fill(check, true);

        int res = 0;
        for(int i = 2; i < n; i++){
            if(check[i]){
                res++;
                if((long)i * i < n){
                    for(int j = i * i; j < n; j += i){
                        check[j] = false;
                    }
                }

            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}