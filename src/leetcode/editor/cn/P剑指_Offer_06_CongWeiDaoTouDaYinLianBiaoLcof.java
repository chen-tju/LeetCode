//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 49 👎 0


package leetcode.editor.cn;

//从尾到头打印链表

import java.util.LinkedList;
import java.util.List;

public class P剑指_Offer_06_CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_06_CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public int[] reversePrint(ListNode head) {
        //利用栈先进后出的特性，利用一个辅助栈完成打印
        LinkedList<ListNode> stack = new LinkedList<>();
        while(head != null){
            stack.addLast(head);
            head = head.next;
        }
//        int[] res = new int[stack.size()];        这里要注意，因为随着remove，stack.size()在变化。。。
//        for(int i = 0; i < stack.size(); i++){
//            res[i] = stack.removeLast().val;
//        }
        int len = stack.size();
        int[] res = new int[len];
        for(int i = 0;  i < len; i++){
            res[i] = stack.removeLast().val;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}