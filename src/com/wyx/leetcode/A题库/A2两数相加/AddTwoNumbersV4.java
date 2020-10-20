package com.wyx.leetcode.A题库.A2两数相加;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
@SuppressWarnings("all")
public class AddTwoNumbersV4 {

	/**
	 * V4参考官方的代码
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1.val == 0 && l1.next == null) {
			return l2;
		}
		if (l2.val == 0 && l2.next == null) {
			return l1;
		}
		ListNode resultNode = new ListNode(-1);
		ListNode node = resultNode;
		int num = 0;
		boolean isNull = false;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				num += l1.val;
				l1 = l1.next;
			} else {
				isNull = true;
			}
			if (l2 != null) {
				num += l2.val;
				l2 = l2.next;
			} else {
				isNull = true;
			}
			node.next = new ListNode(num % 10);
			node = node.next;
			num /= 10;
			if (isNull) {
				// 当l1已经没有了,l2不为空，且num也为0的情况下根本不需要继续走下去了，下面同理
				if (l1 == null && num == 0) {
					node.next = l2;
					return resultNode.next;
				}
				if (l2 == null && num == 0) {
					node.next = l1;
					return resultNode.next;
				}
			}
		}
		if (num > 0) {
			node.next = new ListNode(num);
		}
		// 将一个-1节点剔除
		return resultNode.next;
	}


	public static void main(String[] args) {

		ListNode l11 = new ListNode(8);
		ListNode l12 = new ListNode(9);
		ListNode l13 = new ListNode(9);
		l11.next = l12;
		l12.next = l13;

		ListNode l21 = new ListNode(2);

		ListNode listNode = new AddTwoNumbersV4().addTwoNumbers(l11, l21);
		System.out.println(listNode);


	}
}
