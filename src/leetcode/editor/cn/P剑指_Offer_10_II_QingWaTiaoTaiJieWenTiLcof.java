//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 55 👎 0


package leetcode.editor.cn;

//青蛙跳台阶问题

public class P剑指_Offer_10_II_QingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_10_II_QingWaTiaoTaiJieWenTiLcof().new Solution();
        for(int i = 0; i < 6; i++){
            System.out.println(solution.numWays(i));
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        if(n < 2){
            return 1;
        }
        int a = 0, b = 1, c;
        for(int i = 0; i < n; i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}