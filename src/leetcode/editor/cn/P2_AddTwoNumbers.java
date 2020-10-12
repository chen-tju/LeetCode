//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4697 👎 0


package leetcode.editor.cn;

//两数相加


public class P2_AddTwoNumbers{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2_AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = solution.addTwoNumbers(l1,l2);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);

    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0);
        ListNode i = l1, j = l2, res = resHead;
        int carry = 0;
        while(i != null || j != null){
            int x = (i != null) ? i.val : 0;
            int y = (j != null) ? j.val : 0;
            carry += x + y;
            res.next = new ListNode(carry % 10);
            carry /= 10;
            res = res.next;
            if(i.next != null){
                i = i.next;
            }
            if(j.next != null){
                j = j.next;
            }
        }
        if(carry != 0){
            res.next = new ListNode(carry);
        }
        return resHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}