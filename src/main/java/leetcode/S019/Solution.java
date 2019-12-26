package leetcode.S019;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        int index = length - n;
        first = dummy;
        while (index > 0) {
            index--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
