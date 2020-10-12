//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 178 👎 0


package leetcode.editor.cn;

//二叉搜索树的最小绝对差

import java.util.ArrayList;
import java.util.List;

public class P530_MinimumAbsoluteDifferenceInBst{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P530_MinimumAbsoluteDifferenceInBst().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {//对树进行一个中序遍历
    public int getMinimumDifference(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        dfs(root, vals);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < vals.size() - 1; i++){
            res = Math.min(res, vals.get(i+1) - vals.get(i));
        }
        return res;
    }
    private void dfs(TreeNode root, List<Integer> vals){
        if(root == null){
            return;
        }
        dfs(root.left, vals);
        vals.add(root.val);
        dfs(root.right, vals);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}