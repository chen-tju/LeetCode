//实现函数double Power(double base, int exponent)，求base的exponent次方。
// 不得使用库函数，同时不需要考虑大数问题。
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 62 👎 0


package leetcode.editor.cn;

//数值的整数次方

public class P剑指_Offer_16_ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_16_ShuZhiDeZhengShuCiFangLcof().new Solution();
        Solution1 solution1 = new P剑指_Offer_16_ShuZhiDeZhengShuCiFangLcof().new Solution1();
        System.out.println(solution.myPow(2,-4));
        System.out.println(solution1.myPow(2,4));
    }
    class Solution1{
        public double myPow(double x, int n){
            long tmp = n;
            double res = 1.0;
            if(tmp < 0){
                tmp = -tmp;
                x = 1.0 / x;
            }
            while(tmp > 0){
                if((tmp & 1) == 1){//位运算的优先级最低。。
                    res *= x;
                }
                x *= x;
                tmp >>>= 1;
            }
            return res;
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        return n > 0 ? helper(x, n) : 1.0 / helper(x, n);
    }
    //递归进行调用，计算得到的总是正次幂的数
    private double helper(double x, int n){
        if(n == 0){
            return 1;
        }
        double tmp = helper(x, n/2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}