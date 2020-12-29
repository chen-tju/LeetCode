//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 728 👎 0


package leetcode.editor.cn;

//二叉树的层序遍历

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102_BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();
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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(root.left != null){
                    queue.offer(node.left);
                }
                if(root.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}