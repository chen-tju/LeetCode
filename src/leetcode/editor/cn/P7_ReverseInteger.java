//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2086 👎 0


package leetcode.editor.cn;
//Java：整数反转
public class P7_ReverseInteger{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P7_ReverseInteger().new Solution();
        Solution1 solution1 = new P7_ReverseInteger().new Solution1();
        int x = -124;
        System.out.println(solution.reverse(x));
        System.out.println(solution1.reverse(x));
    }
    class Solution1{
        public int reverse(int x){
            long res = 0L;
            while(x != 0){
                res = res * 10 + x % 10;
                x /= 10;
            }
            return (int)res == res ? (int)res : 0;
        }
    }
//力扣代码-
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        String a = Integer.toString(x);
        int flag = 1;
        if(a.charAt(0) == '-'){
            a = a.substring(1);
            flag = -1;
        }
        char[] res = new char[a.length()];
        for(int i = a.length() - 1; i >= 0; i--){
            res[a.length() - 1 - i] = a.charAt(i);
        }
        Long value = Long.valueOf(new String(res));
        if(value > Integer.MAX_VALUE || value < Integer.MIN_VALUE){
            return 0;
        }
        return (int)(value * flag);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}