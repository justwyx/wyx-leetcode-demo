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
public class ReverseListV2 {

	/**
	 * 参考官方题解
	 * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，
	 * 因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode result = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = result;
			result = head;
			head = next;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{1, 2, 3, 4, 5});
		head = reverseList(head);
		ListNodeUtil.println(head);
	}
}
