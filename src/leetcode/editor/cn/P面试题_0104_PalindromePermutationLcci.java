//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 30 👎 0


package leetcode.editor.cn;

//回文排列

import java.util.HashSet;
import java.util.Set;

public class P面试题_0104_PalindromePermutationLcci{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P面试题_0104_PalindromePermutationLcci().new Solution();
        Solution1 solution1 = new P面试题_0104_PalindromePermutationLcci().new Solution1();
        String s = "tactcoa";
        System.out.println(solution.canPermutePalindrome(s));
        System.out.println(solution1.canPermutePalindrome(s));
    }
    class Solution1{
        public boolean canPermutePalindrome(String s){
            int[] dic = new int[128];
            for(int i : s.toCharArray()){//将字符作为数组下标
                dic[i] ++;
            }
            int count = 0;
            for(int n : dic){
                if(n % 2 == 1){
                    count++;
                }
            }
            return count <= 1 ? true : false;
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
        }
        return set.size() <= 1 ? true : false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}