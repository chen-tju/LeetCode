//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 143 👎 0


package leetcode.editor.cn;

//n个骰子的点数

public class P剑指_Offer_60_NgeTouZiDeDianShuLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_60_NgeTouZiDeDianShuLcof().new Solution();
        double[] res = solution.dicesProbability(2);
        for (double re : res) {
            System.out.print(re + "、");
        }
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
        //动态规划，由前n-1个骰子的结果推出n个骰子的结果
        double[] pre = {1/6d, 1/6d, 1/6d, 1/6d, 1/6d, 1/6d};
        for(int i = 2; i <= n; i++){
            double[] tmp = new double[i * 5 + 1];
            for(int j = 0; j < pre.length; j++){
                for(int k = 0; k < 6; k++){
                    tmp[j + k] += pre[j] / 6;
                }
            }
            pre = tmp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}