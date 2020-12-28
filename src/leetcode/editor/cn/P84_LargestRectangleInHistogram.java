//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1099 👎 0


package leetcode.editor.cn;


import java.util.Deque;
import java.util.LinkedList;

//Java：柱状图中最大的矩形
public class P84_LargestRectangleInHistogram{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P84_LargestRectangleInHistogram().new Solution();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(heights));
        
    }
//力扣代码-
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {//标准解法就是使用单调栈，然后加上哨兵的技巧
    //遍历每个柱体，若当前的柱体高度大于等于栈顶柱体的高度，就直接将当前柱体入栈，
    //否则若当前的柱体高度小于栈顶柱体的高度，说明当前栈顶柱体找到了右边的第一个小于自身的柱体，
    //那么就可以将栈顶柱体出栈来计算以其为高的矩形的面积了。
    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();//首先要明确，栈中存放的是柱体的下标
        for (int i = 0; i < tmp.length; i++) {
            //当栈不为空并且当前柱体的高度小于栈顶坐标的柱体高度时，进行一次出站和比较
            while(!stack.isEmpty() && tmp[i] < tmp[stack.getLast()]){
                int height = tmp[stack.removeLast()];
                res = Math.max(res, height * (i - stack.getLast() - 1 ));//以当前出栈的柱体高度为高，i是右边第一个小于height的下标，栈顶是左边第一个
            }
            stack.addLast(i);//只有当当前柱体高度大于等于栈顶柱体高度的时候才入栈
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}