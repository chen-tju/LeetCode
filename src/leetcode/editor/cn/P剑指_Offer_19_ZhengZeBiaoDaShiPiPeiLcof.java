//
//
// 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
// 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。
// 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 动态规划 
// 👍 89 👎 0

//这道题比较经典，还没啃透，害
package leetcode.editor.cn;

//正则表达式匹配

public class P剑指_Offer_19_ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_19_ZhengZeBiaoDaShiPiPeiLcof().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m+1][n+1];//f[i][j] 代表字符串s的前 i 个字符和字符串p的前 j 个能否匹配
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(j == 0){//空正则
                    f[i][j] = i == 0; //空正则只能匹配空
                }else{//非空正则， 要判断最后一个字符是不是 * ，*表示前面的字符可以出现任意次
                    if(p.charAt(j-1) != '*'){//最后一个字符不是 *
                        if(i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')){
                            f[i][j] = f[i-1][j-1];
                        }
                    }else{
                        if(j >= 2){
                            f[i][j] |= f[i][j-2];
                        }
                        if(i >= 1 && j >= 2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')){
                            f[i][j] |= f[i-1][j];
                        }
                    }
                }
            }
        }
        return f[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
