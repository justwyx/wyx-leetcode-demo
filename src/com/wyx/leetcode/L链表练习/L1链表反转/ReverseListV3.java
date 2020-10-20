package com.wyx.leetcode.L链表练习.L1链表反转;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

/**
 * @Description :
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author : Just wyx
 * @Date : 2020/9/23
 */
public class ReverseListV3 {

	/**
	 * 递归
	 */
	public static ListNode reverseList(ListNode head) {
		// 先写循环退出条件
		if (head == null || head.next == null) return head;
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{1, 2, 3, 4, 5});
		head = reverseList(head);
		ListNodeUtil.println(head);
	}
}
