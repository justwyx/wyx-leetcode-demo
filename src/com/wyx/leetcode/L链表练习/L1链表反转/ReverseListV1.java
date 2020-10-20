package com.wyx.leetcode.L链表练习.L1链表反转;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

import java.util.List;

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
public class ReverseListV1 {

	/**
	 *
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 先记录第一个节点
		ListNode result = new ListNode(head.val);
		while (head.next != null) {
			// 下个节点不能空的情况下，将下一个节点赋给head
			head = head.next;
			// 利用 head 生成一个新节点 cur
			ListNode cur = new ListNode(head.val);
			cur.next = result;
			result = cur;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{1, 2, 3, 4, 5});
		head = reverseList(head);
		ListNodeUtil.println(head);
	}
}
