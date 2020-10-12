//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 77 👎 0


package leetcode.editor.cn;

//链表中倒数第k个节点

public class P剑指_Offer_22_LianBiaoZhongDaoShuDiKgeJieDianLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_22_LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list. */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for(int i = k; i < k; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        /***  Another solve
         *    int t = 0;
         *    while(fast != null){
         *      if(t >= k){
         *          slow = slow.next;
         *       }
         *      fast = fast.next;
         *      t++;
         *    }
         *
         */
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}