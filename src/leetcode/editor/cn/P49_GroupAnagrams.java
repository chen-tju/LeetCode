//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 594 👎 0


package leetcode.editor.cn;

//字母异位词分组

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49_GroupAnagrams{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P49_GroupAnagrams().new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution.groupAnagrams(strs);
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp= new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if(count[i] != 0){
                    sb.append((char)('a' + i));
                    sb.append(count[i]);
                }
            }
            List<String> list = mp.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            mp.put(sb.toString(), list);
        }
        return new ArrayList<List<String>>(mp.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}