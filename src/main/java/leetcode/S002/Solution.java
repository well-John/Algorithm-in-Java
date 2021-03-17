package leetcode.S002;

import define.ListNode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean jinwei = false;
        ListNode node = new ListNode();
        ListNode res = node;
        while (l1 != null && l2 != null) {
            int temp = l1.getVal() + l2.getVal();
            if (jinwei) {
                temp++;
            }
            jinwei = false;
            if (temp > 9) {
                jinwei = true;
                temp %= 10;
            }
            ListNode tmp = new ListNode(temp);
            node.setNext(tmp);
            node = node.getNext();
            l1 = l1.getNext();
            l2 = l2.getNext();
        }


        while (l1 != null) {
            int temp = l1.getVal();
            if (jinwei) {
                temp++;
            }
            jinwei = false;
            if (temp > 9) {
                jinwei = true;
                temp %= 10;
            }
            ListNode tmp = new ListNode(temp);
            node.setNext(tmp);
            node = node.getNext();
            l1 = l1.getNext();
        }

        while (l2 != null) {
            int temp = l2.getVal();
            if (jinwei) {
                temp++;
            }
            jinwei = false;
            if (temp > 9) {
                jinwei = true;
                temp %= 10;
            }
            ListNode tmp = new ListNode(temp);
            node.setNext(tmp);
            node = node.getNext();
            l2 = l2.getNext();
        }


        if (jinwei) {
            ListNode tmp = new ListNode(1);
            node.setNext(tmp);
        }

        return res.getNext();
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        node1.setNext(node2);
        node2.setNext(node3);

        ListNode node_1 = new ListNode(9);
        ListNode node_2 = new ListNode(9);
        ListNode node_3 = new ListNode(9);
        ListNode node_4 = new ListNode(9);
        node_1.setNext(node_2);
        node_2.setNext(node_3);
        node3.setNext(node_4);

        node1.output();
        System.out.println("");
        node_1.output();
        System.out.println("");


        ListNode listNode = new Solution().addTwoNumbers(node1, node_1);

        listNode.output();
    }

}
