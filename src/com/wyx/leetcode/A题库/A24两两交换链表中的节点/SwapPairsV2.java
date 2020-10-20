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
public class SwapPairsV2 {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode headNext = head.next;
		head.next = swapPairs(headNext.next);
		headNext.next = head;
		return headNext;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{1, 2, 3, 4});
		head = swapPairs(head);
		ListNodeUtil.println(head);
	}
}
