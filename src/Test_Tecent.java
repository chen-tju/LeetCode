public class Test_Tecent {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    private static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(slow != head){
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }

    public static int climbStairs(int n) {
        int a = 1, b = 1, c = 0;
        for(int i = 0; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(price, min);
            res = Math.max(res, price - min);
        }
        return res;
    }
}

