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
public class AddTwoNumbersV1 {

	/**
	 * 这道题最先想到地是先提供两个工具方法
	 * 1.链表转整数
	 * 2.整数转链表
	 * 执行流程
	 * 1.将两个链表转成整数并相加
	 * 2.结得到的结果转成链表
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 先获取两个链表代表的整数
		int num = convertToInt(l1) + convertToInt(l2);
		// 将整数反转成链表输出
		return convertToListNode(num);
	}
	/**
	 * 链表转int
	 * 例：
	 * 	 链表 2 -> 4 -> 3 ==> 342
	 * 转换方法
	 *   (2 * 10^0) + (4 * 10^1) + (3 * 10^2)
	 */
	private static int convertToInt(ListNode list) {
		// 结果整数
		int result = 0;
		// 索引位置
		int index = 0;
		while (list != null) {
			// 整数累加
			result += list.val * Math.pow(10, index++);
			// 将下一个节点赋值给list，之前的节点由于没有引用，后续会被垃圾回收器回收
			list = list.next;
		}
		return result;
	}
	/**
	 * 整数转链表
	 * 例：
	 *   整数 807 ==> 7 -> 0 -> 8
	 * 	 对整数进行反转的时候，依次添加进链表
	 * 注：忽略了非正数的情况
	 */
	private ListNode convertToListNode(int num) {
		// 第一个节点
		ListNode result = new ListNode(num % 10);
		// 将num
		num /= 10;
		// 定义临时节点
		ListNode node = result;
		while (num > 0) {
			node.next = new ListNode(num % 10);
			num /= 10;
			node = node.next;
		}
		return result;
	}

//	/**
//	 * 单链表反转,采用的是用一个新链表和一个临时节点的方式进行反转的
//	 */
//	private static ListNode overturn(ListNode list) {
//		// 定义一个临时节点
//		ListNode node;
//		// 定义一个新链表
//		ListNode newNode = null;
//		while (list != null) {
//			// 将临时节点指向当前节点
//			node = list;
//			// 先将链表的下一个节点指向当前节点，之前那个节点因为没有了引用，会被垃圾回收
//			list = list.next;
//
//			// 临时节点的下一下节点指向新节点
//			node.next = newNode;
//			// 将临时节点赋值给新节点
//			newNode = node;
//		}
//		// 返回新链表
//		return newNode;
//	}





	public static void main(String[] args) {
//		ListNode l11 = new ListNode(2);
//		ListNode l12 = new ListNode(4);
//		ListNode l13 = new ListNode(3);
//		l11.next = l12;
//		l12.next = l13;
//		ListNode l21 = new ListNode(5);
//		ListNode l22 = new ListNode(6);
//		ListNode l23 = new ListNode(4);
//		l21.next = l22;
//		l22.next = l23;

		ListNode l11 = new ListNode(8);
		ListNode l12 = new ListNode(9);
		ListNode l13 = new ListNode(9);
		l11.next = l12;
		l12.next = l13;

		ListNode l21 = new ListNode(2);

		ListNode listNode = new AddTwoNumbersV1().addTwoNumbers(l11, l21);
		System.out.println(listNode);


	}
}
