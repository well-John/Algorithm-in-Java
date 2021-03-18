package leetcode.S023;

import define.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        for (int i=0;i<lists.length;i++){
            node = mergeTwoList(node,lists[i]);
        }
        return node;
    }

    public ListNode mergeTwoList(ListNode a,ListNode b){
        if(a == null || b==null){
            return a==null?b:a;
        }

        ListNode head = new ListNode();
        ListNode res = head;
        while(a != null && b!= null){
            if(a.val < b.val){
                head.next = new ListNode(a.val);
                head = head.next;
                a = a.next;
            }else {
                head.next = new ListNode(b.val);
                head = head.next;
                b = b.next;
            }
        }

        if(a != null){
            head.next = a;
        }

        if(b != null){
            head.next = b;
        }
        return res.next;
    }
}
