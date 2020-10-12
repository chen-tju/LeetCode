//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 910 👎 0


package leetcode.editor.cn;

//电话号码的字母组合   -----回溯法

import java.util.ArrayList;
import java.util.List;

public class P17_LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> res = solution.letterCombinations("23");
        for(String str : res){
            System.out.println(str);
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<String>();
        }
        String[] map = {
                " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for(int i = 0; i < digits.length(); i++){//逐个读取数字
            String letter = map[digits.charAt(i) - '0']; // 从数组中读取该数字所对应的字母
            int size = res.size(); //因为res的大小在不断变化，因此先存一下
            for(int j = 0; j < size; j++){
                String tmp = res.remove(0);//tmp是res队列中第一个字符
                for(int k = 0; k < letter.length(); k++){
                    res.add(tmp + letter.charAt(k));
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}