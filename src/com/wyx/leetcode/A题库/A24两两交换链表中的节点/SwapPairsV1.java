package com.wyx.leetcode.A题库.A24两两交换链表中的节点;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

/**
 * @Description :
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @author : Just wyx
 * @Date : 2020/10/13
 */
public class SwapPairsV1 {
	public static ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode temp = dummyHead;
		while (temp.next != null && temp.next.next != null) {
			ListNode node1 = temp.next;
			ListNode node2 = temp.next.next;
			temp.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			temp = node1;
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{1, 2, 3, 4});
		head = swapPairs(head);
		ListNodeUtil.println(head);
	}
}
