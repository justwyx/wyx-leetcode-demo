package com.wyx.leetcode.utils;

import com.wyx.leetcode.common.ListNode;

/**
 * @author : Just wyx
 * @Description : TODO 2020/9/23
 * @Date : 2020/9/23
 */
public class ListNodeUtil {
	/**
	 * 根据数据生成链表
	 */
	public static ListNode build(int[] intArray) {
		ListNode result = new ListNode(-1);
		ListNode cur = result;
		for (int i = 0; i < intArray.length; i++) {
			cur.next = new ListNode(intArray[i]);
			cur = cur.next;
		}
		return result.next;
	}

	/**
	 * 打印链表内容
	 */
	public static void println(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
