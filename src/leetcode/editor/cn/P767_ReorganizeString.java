//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 246 👎 0


package leetcode.editor.cn;

//重构字符串

import javafx.util.Pair;

public class P767_ReorganizeString{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P767_ReorganizeString().new Solution();
        System.out.println(solution.reorganizeString("aab"));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//基于计数的贪心算法
        //本题的关键其实就在于，只要字母的出现次数不超过字符串的长度的一半，奇数偶数隔一个位置放一个就可以实现
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int max = 0;
        for(int i = 0; i < S.length(); i++){
            count[S.charAt(i) - 'a']++;
            max = Math.max(max, count[i]);
        }

        if(max > (S.length() + 1) / 2){
            return "";
        }
        char[] res = new char[S.length()];
        int odd = 1, even = 0, mid = S.length() / 2;
        for(int i = 0; i < 26; i++){
            while(count[i] > 0 && odd < S.length() && count[i] <= mid){//这里注意是小于等于，因为当等于一半的时候，也是可以放下的
                count[i]--;
                res[odd] = (char)('a' + i);
                odd += 2;
            }
            //如果跳出了上一个循环，说明这个数字大于一半或者是odd指针到了最后面，就开始放进偶数坐标下面
            while(count[i] > 0){
                res[even] = (char)('a' + i);
                count[i]--;
                even += 2;
            }
        }
        return new String(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}