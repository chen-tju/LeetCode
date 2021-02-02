//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 315 👎 0


package leetcode.editor.cn;

//替换后的最长重复字符

/***
 * 经典的双指针题目
 * 题意翻译过来就是：在字符串中找一个最长的区间，这个区间中不是最多的字符的数量不能大于k
 *
 * 枚举字符串中的每一个位置作为右端点，然后找到其最远的左端点的位置，满足该区间内除了出现次数最多的那一类字符之外，
 * 剩余的字符（即非最长重复字符）数量不超过 k 个。
 *
 *
 */

public class P424_LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P424_LongestRepeatingCharacterReplacement().new Solution();
        System.out.println(solution.characterReplacement("AABABBA", 1));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, most = 0;//定义一个历史最大值
        //most这里指之前出现的最多次数，不需要担心这个数在不在当前区间内
        //如果不在的话，之前这个最多次数在之前已经计算过，这里肯定不是最终结果--没有意义
        //即该区间内非最长重复字符超过了 k 个。但是这样的区间也同样不可能对答案产生贡献。
        int[] nums = new int[26];//这里是定义一个长度为26的数组用于计算每个字符出现的次数
        while(right < s.length()){//如果右指针没有走到边界就执行
            nums[s.charAt(right) - 'A']++;//右指针指向的字符加一

            //更新历史最大数量---比较右指针当前的字符数量与之前出现的字符最大数量
            most = Math.max(most, nums[s.charAt(right) - 'A']);
            //如果区间长度减去出现最多的次数剩余比k大，说明当前区间不满足，左指针右移
            if(right - left + 1 - most > k){
                nums[s.charAt(left) - 'A']--;
                left++;
            }
            right++;//right会多走一步
        }
        return right - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}