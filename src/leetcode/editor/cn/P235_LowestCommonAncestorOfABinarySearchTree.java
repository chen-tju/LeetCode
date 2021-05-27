//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 
// 👍 584 👎 0


package leetcode.editor.cn;

//二叉搜索树的最近公共祖先

import java.util.ArrayList;
import java.util.List;

public class P235_LowestCommonAncestorOfABinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P235_LowestCommonAncestorOfABinarySearchTree().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root.val > p.val && root.val > q.val){
//            return lowestCommonAncestor(root.left, p, q);
//        }else if (root.val < p.val && root.val < q.val){
//            return lowestCommonAncestor(root.right, p, q);
//        }else{
//            return root;
//        }
        List<TreeNode> pRoots = getRoots(root, p);
        List<TreeNode> qRoots = getRoots(root, q);
        int n = Math.min(pRoots.size(), qRoots.size());
        TreeNode res = null;
        for(int i = 0; i < n; i++){
            if(pRoots.get(i) == qRoots.get(i)){
                res = pRoots.get(i);
            }else{
                break;
            }
        }
        return res;
    }
    private List<TreeNode> getRoots(TreeNode root, TreeNode node){
        List<TreeNode> res = new ArrayList<>();
        while(root.val != node.val){
            res.add(root);
            root = root.val > node.val ? root.left : root.right;
        }
        res.add(root);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
