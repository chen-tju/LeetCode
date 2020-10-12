//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/ 
// Related Topics 递归 
// 👍 52 👎 0


package leetcode.editor.cn;

//斐波那契数列

public class P剑指_Offer_10_I_FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_10_I_FeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(5));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        int a = 0, b = 1, c;
        for(int i = 0; i < n; i++){
            c = (a + b) % 1000000007;   //这里要进行取模操作
            a = b;
            b = c;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}