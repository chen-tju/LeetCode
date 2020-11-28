//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1289 👎 0


package leetcode.editor.cn;

//反转链表

public class P206_ReverseLinkedList{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P206_ReverseLinkedList().new Solution();
    }

    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;//定义一个新的结点
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


//递归
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}