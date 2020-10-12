//
//
//
// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 96 👎 0


package leetcode.editor.cn;

//剪绳子

public class P剑指_Offer_14I_JianShengZiLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_14I_JianShengZiLcof().new Solution();
        Solution1 solution1 = new P剑指_Offer_14I_JianShengZiLcof().new Solution1();
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.cuttingRope(58));
        System.out.println(solution1.cuttingRope(58));
    }
    class Solution1{
        public int cuttingRope(int n){
            if(n < 5){
                return n - 1;
            }
            int res = 1;
            while(n > 4){
                res *= 3;
                n -= 3;
            }
            return res * n;
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    //数学问题，拆成m个3相乘，乘积最大
class Solution {
    public int cuttingRope(int n) {
        if(n < 5){
            return n-1;
        }
        if(n % 3 == 0){
            return (int)Math.pow(3, n/3);
        }else if(n % 3 == 1){
            return (int)Math.pow(3, n/3 - 1) * 4;
        }else if(n % 3 == 2){
            return (int)Math.pow(3, n/3) * 2;
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}