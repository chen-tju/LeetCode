//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 367 👎 0


package leetcode.editor.cn;

//重排链表

public class P143_ReorderList{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P143_ReorderList().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        merge(l1, l2);
        
    }
    private ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    private void merge(ListNode l1, ListNode l2){
        ListNode l1_tmp, l2_tmp;
        while(l1 != null && l2 != null){
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            l1.next = l2;
            l1 = l1_tmp;
            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}