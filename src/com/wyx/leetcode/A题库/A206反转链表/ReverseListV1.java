package com.wyx.leetcode.A题库.A206反转链表;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

/**
 * @author : Just wyx
 * @Description : TODO 2020/10/20
 * @Date : 2020/10/20
 */
public class ReverseListV1 {
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{1, 2, 3, 4, 5});
		head = reverseList(head);
		ListNodeUtil.println(head);
	}
}
