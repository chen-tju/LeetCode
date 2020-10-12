//给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 
//
// 示例 1： 
//
// 输入：["abcd","dcba","lls","s","sssll"]
//输出：[[0,1],[1,0],[3,2],[2,4]] 
//解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2： 
//
// 输入：["bat","tab","cat"]
//输出：[[0,1],[1,0]] 
//解释：可拼接成的回文串为 ["battab","tabbat"] 
// Related Topics 字典树 哈希表 字符串 
// 👍 133 👎 0


package leetcode.editor.cn;

//回文对

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P336_PalindromePairs{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P336_PalindromePairs().new Solution();
        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        System.out.println(solution.palindromePairs(words));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(valid(words[i],words[j])){
                    //ArrayList<Integer> tmp = new ArrayList<>(Arrays.asList(i,j));
                    res.add(Arrays.asList(i,j));
                }
                if(valid(words[j],words[i])){
                    res.add(Arrays.asList(j,i));
                }
            }
        }
        return res;

    }
    private boolean valid(String str1, String str2){
        String str = str1 + str2;
        int left = 0, right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}