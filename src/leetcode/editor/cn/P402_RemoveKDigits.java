//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 470 👎 0


package leetcode.editor.cn;

//移掉K位数字

public class P402_RemoveKDigits{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P402_RemoveKDigits().new Solution();
        System.out.println(solution.removeKdigits("1432219",3));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//贪心算法
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for(int i = 0; i < k; i++){
            int idx = 0;
            for(int j = 1; j < sb.length() && sb.charAt(j) >= sb.charAt(j - 1); j++){
                idx = j;
            }
            sb.delete(idx, idx + 1);
            while(sb.length() > 0 && sb.charAt(0) == '0'){
                sb.delete(0,1);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}