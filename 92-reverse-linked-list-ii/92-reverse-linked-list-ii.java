/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode Sent, c, p, n, tmp1, tmp2;
        int i = 1;
        Sent = new ListNode(0);
        Sent.next = head;
        p = Sent;
        c = head;
        n = head.next;
        tmp1 = tmp2 = null;
        while (i <= right) {
            if (i == left) {
                tmp1 = p;
                tmp2 = c;
            } else if (i > left && i <= right) {
                c.next = p;
            }
            p = c;
            c = n;
            n = n == null ? null : n.next;// problem line
            ++i;
        }
        tmp1.next = p;
        tmp2.next = c;
        return Sent.next;
    }
}