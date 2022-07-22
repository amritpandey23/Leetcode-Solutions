class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode part1, part2, p1, p2;
        part1 = new ListNode(0);
        part2 = new ListNode(0);
        p1 = part1;
        p2 = part2;
        
        while (head != null) {
            if (head.val < x) {
                part1.next = head;
                part1 = part1.next;
            } else {
                part2.next = head;
                part2 = part2.next;
            }
            head = head.next;
        }
        
        part2.next = null;
        part1.next = p2.next;
        return p1.next;
    }
}