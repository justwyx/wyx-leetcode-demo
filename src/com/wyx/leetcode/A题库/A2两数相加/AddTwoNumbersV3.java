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
public class AddTwoNumbersV3 {

	/**
	 * V3版本想解决的是
	 * 例：[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
	 * [1]
	 * 这种情况下，算完第一个数字之后，根本不需要在向下执行下去，直接将后续长的链表接到结果链表返回就可以了，同步参考了评论区一个大佬的精简代码实现
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
		while (l1 != null || l2 != null || num != 0) {
			// 当l1不为空，l2已经没有了，且num也为0的情况下根本不需要继续走下去了，下面同理
			if (l1 != null && l2 == null && num == 0) {
				node.next = l1;
				return resultNode.next;
			}
			if (l1 == null && l2 != null && num == 0) {
				node.next = l2;
				return resultNode.next;
			}
			if (l1 != null) {
				num += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				num += l2.val;
				l2 = l2.next;
			}
			node.next = new ListNode(num % 10);
			node = node.next;
			num /= 10;
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

		ListNode listNode = new AddTwoNumbersV3().addTwoNumbers(l11, l21);
		System.out.println(listNode);


	}
}
