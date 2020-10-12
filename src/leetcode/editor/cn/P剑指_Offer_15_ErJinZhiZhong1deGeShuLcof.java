//
//
// 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。
// 因此，如果输入 9，则该函数输出2。
//
// 示例 1： 
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/ 
// Related Topics 位运算 
// 👍 43 👎 0


package leetcode.editor.cn;

//二进制中1的个数

public class P剑指_Offer_15_ErJinZhiZhong1deGeShuLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_15_ErJinZhiZhong1deGeShuLcof().new Solution();
        System.out.println(solution.hammingWeight(9));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    //一道经典的位运算的题目。
    //还有这里不需要进行二进制的转换。///但是力扣给的输入输出就很迷。。。。。
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res += n&1; //从最低位，与1相与，有一个1加一
            n >>>= 1;
            ///还有一种写法，是计算n与n-1相与的次数
            //res++;
            //n &= n-1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}