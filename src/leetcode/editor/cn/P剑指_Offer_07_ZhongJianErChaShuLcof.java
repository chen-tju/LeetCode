//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 179 👎 0


package leetcode.editor.cn;

//重建二叉树

import java.util.HashMap;

public class P剑指_Offer_07_ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_07_ZhongJianErChaShuLcof().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
//pre ： 根 左 右    in ： 左 根 右
class Solution {
     HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            dic.put(inorder[i], i);
        }
        return helper(preorder, 0, 0, inorder.length - 1);
    }
//定义一个辅助函数，preorder是先序遍历结果数组， pre_root是先序遍历中根节点的位置，
//in_left 是左子树或右子树在中序遍历中的左边界， in_right是右边界
    private TreeNode helper(int[] preorder, int pre_root, int in_left, int in_right){
        if(in_left > in_right){
            return null;
        }
        int i = dic.get(preorder[pre_root]); //i是先序遍历中根节点在中序遍历中的索引位置
        TreeNode root = new TreeNode(dic.get(i));
        root.left = helper(preorder, pre_root + 1, in_left, i - 1);
        root.right = helper(preorder, i - in_left + pre_root + 1, i + 1, in_right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}