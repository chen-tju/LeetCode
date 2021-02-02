//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 627 👎 0


package leetcode.editor.cn;

//反转链表 II

public class P92_ReverseLinkedListIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P92_ReverseLinkedListIi().new Solution();
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.*/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for(int i = m; i < n; i++){
            ListNode next = cur.next;

            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}