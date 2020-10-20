package com.wyx.leetcode.L链表练习.L4删除链表的倒数第N个节点;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

/**
 * @Description :
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/24
 */
public class RemoveNthFromEndV2 {

	/**
	 * 循环两次
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode remove = dummy;
		int length = 0;
		while (head.next != null) {
			length++;
			head = head.next;
		}
		length -= n;
		while (length >= 0) {
			length--;
			remove = remove.next;
		}
		remove.next = remove.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = ListNodeUtil.build(new int[]{1, 2});
		ListNode l2 = removeNthFromEnd(l1, 2);
		ListNodeUtil.println(l2);
	}
}
