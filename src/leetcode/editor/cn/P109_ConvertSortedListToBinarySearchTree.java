//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 298 👎 0


package leetcode.editor.cn;

//有序链表转换二叉搜索树

public class P109_ConvertSortedListToBinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P109_ConvertSortedListToBinarySearchTree().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    class Solution1{
        public TreeNode sortedListToBST(ListNode head){
            if(head == null){
                return null;
            }
            return helper(head,null);
        }
        private TreeNode helper(ListNode head, ListNode tail){
            if(head == tail){
                return null;      //跳出递归
            }
            ListNode slow = head, fast = head;
            while(fast != tail && fast.next != tail){
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode root = new TreeNode(slow.val);
            root.left = helper(head, slow);
            root.right = helper(slow.next, tail);
            return root;
        }
    }
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        if(mid == head){
            return root;
        }
        root.left = sortedListToBST(head);//左子树
        root.right = sortedListToBST(mid.next);//右子树
        return root;
    }
    //利用快慢指针查找中间节点，并断开连接
    private ListNode findMid(ListNode head){
        ListNode slow = head, fast = head, pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null){
            pre.next = null;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}