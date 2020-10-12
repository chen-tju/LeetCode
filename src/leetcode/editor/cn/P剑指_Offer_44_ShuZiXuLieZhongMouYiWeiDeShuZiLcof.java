//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 52 👎 0


package leetcode.editor.cn;

//数字序列中某一位的数字

public class P剑指_Offer_44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        System.out.println(solution.findNthDigit(25));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/* 数字范围    数量  位数    占多少位
    1-9        9      1       9
    10-99      90     2       180
    100-999    900    3       2700
    1000-9999  9000   4       36000  ...

    例如 2901 = 9 + 180 + 2700 + 12 即一定是4位数,第12位   n = 12;
    数据为 = 1000 + (12 - 1)/ 4  = 1000 + 2 = 1002
    定位1002中的位置 = (n - 1) %  4 = 3    s.charAt(3) = 2;
*/
class Solution {
    public int findNthDigit(int n) {
        int digit = 1; //定义digit为数字n所在数字的位数
        long start = 1; //start为数字范围开始的第一个数 几位的数字开始的第一个数肯定是1、10、100、。。。
        long count = 9;//占了多少位   就分别每个位数占：9 * 1， 90*2，900*3，。。。
        while(n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n-1) / digit;//跳出循环，根据上次循环的start、n、digit计算出所在的数字
        return Long.toString(num).charAt((n-1) % digit) - '0';//转换为字符串，然后求出数字中的对digit求余位
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}