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
public class AddTwoNumbersV2 {

	/**
	 * 这道题可能会出现很大的数字，将链表转成数字的时候就已经超过了int的最大值，用long也不行，因为测试用例中有超长的链表
	 * 一开始就说了被误导了，其实认真观察可以发现，根本不需要转来转去
	 * (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * 可以想成是
	 * 2 + 5 -> 4 + 6 -> 3 + 4
	 * 只是要注意两条链表不对等及需要进位的情况
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1.val == 0 && l1.next == null) {
			return l2;
		}
		if (l2.val == 0 && l2.next == null) {
			return l1;
		}
		// 当前节点的值
		int num;
		// 溢出值(进位值),用于下一步累加，如6 + 6 = 12，那么 num = 2, overflowNum = 1
		int overflowNum = 0;
		// 两个列表第一位进行想加
		num = l1.val + l2.val;
		if (num >= 10) {
			overflowNum = 1;
			num %= 10;
		}
		// 返回的节点
		ListNode resultNode = new ListNode(num);
		// 两个链表分别指向下一个链表
		l1 = l1.next;
		l2 = l2.next;

		int val1, val2;
		// 临时节点
		ListNode node = resultNode;
		while (true) {
			if (l1 == null && l2 == null) {
				// 有进位值则有一个节点
				if (overflowNum == 1) {
					node.next = new ListNode(1);
				}
				return resultNode;
			}
			val1 = l1 == null? 0 : l1.val;
			val2 = l2 == null? 0 : l2.val;
			// 这里需要将进位值一起加上
			num = val1 + val2 + overflowNum;
			if (num >= 10) {
				overflowNum = 1;
				num %= 10;
			} else {
				overflowNum = 0;
			}
			node.next = new ListNode(num);
			node = node.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
	}

	public static void main(String[] args) {

		ListNode l11 = new ListNode(8);
		ListNode l12 = new ListNode(9);
		ListNode l13 = new ListNode(9);
		l11.next = l12;
		l12.next = l13;

		ListNode l21 = new ListNode(2);

		ListNode listNode = new AddTwoNumbersV2().addTwoNumbers(l11, l21);
		System.out.println(listNode);


	}
}
