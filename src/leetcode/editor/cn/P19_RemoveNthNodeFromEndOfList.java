//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1064 👎 0


package leetcode.editor.cn;

//删除链表的倒数第N个节点

public class P19_RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 *
 * */

public class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//这道题让我真正意义上对链表ListNode的数据结构，结合栈有了新的认知
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode slow = dummy;
        ListNode fast = head;
        //ListNode slow = head;//这样的话，slow最终指向倒数第n个节点，不方便操作。因此添加进dummy节点
        while(n != 0){
            fast = fast.next;
            n--;
        }
        while(fast != null){//此时，当fast节点指向末尾的null节点，slow指向的是倒数第n个节点的前驱节点
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        //return head;  //如果只有一个节点，并删除了它即错误
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}