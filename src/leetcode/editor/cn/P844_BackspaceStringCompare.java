//
//
// 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
// # 代表退格字符。
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 188 👎 0


package leetcode.editor.cn;

//比较含退格的字符串

public class P844_BackspaceStringCompare{
    public static void main(String[] args) {
        //测试代码
        Solution1 solution1 = new P844_BackspaceStringCompare().new Solution1();
        String S = "y#fo##f", T = "y#f#o##f";
        System.out.println(solution1.backspaceCompare(S, T));
    }
//双指针想法，从末尾往前遍历一遍。定义两个skip变量记录#的数量。
    class Solution1{
        public boolean backspaceCompare(String S, String T){
            int sS = 0, sT = 0;
            int i = S.length() - 1, j = T.length() - 1;
            while(i >= 0 || j >= 0){
                while(i >= 0){
                    if(S.charAt(i) == '#'){
                        sS++;
                        i--;
                    }else if(sS > 0){
                        sS--;
                        i--;
                    }else{
                        break;
                    }
                }
                while(j >= 0){
                    if(T.charAt(j) == '#'){
                        sT++;
                        j--;
                    }else if(sT > 0){
                        sT--;
                        j--;
                    }else{
                        break;
                    }
                }
                if(i >= 0 && j >= 0){
                    if(S.charAt(i) != T.charAt(j)){
                        return false;
                    }
                }else{
                    if(i >= 0 || j >= 0){
                        return false;
                    }
                }
                i--;
                j--;
            }
            return true;
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

//这里是利用栈的思想，借助StringBuilder来进行操作
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }
    private String helper(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c != '#'){
                sb.append(c);
            }else{
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

            // 像下面这样写的话，会导致如果sb为空且下一个字符为#，#会加入sb中
            //  if(sb.length() > 0 && c == '#'){
            //      sb.deleteCharAt(sb.length() - 1);
            //  }else{
            //      sb.append(c);
            //  }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}