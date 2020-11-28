//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 334 👎 0


package leetcode.editor.cn;

//划分字母区间

import java.util.ArrayList;
import java.util.List;

public class P763_PartitionLabels{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P763_PartitionLabels().new Solution();
        String S = "ababcbacadefegdehijhklij";
        List<Integer> res = solution.partitionLabels(S);
        System.out.println(res);
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String S) {
        //定义一个长度为26的数组，用于存放每个字母最后一次出现的下标
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}