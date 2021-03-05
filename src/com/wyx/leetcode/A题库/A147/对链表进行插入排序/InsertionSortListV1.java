package com.wyx.leetcode.A题库.A147.对链表进行插入排序;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author : Just wyx
 * @Date : 2020/11/20
 */
public class InsertionSortListV1 {
	public ListNode insertionSortList(ListNode head) {
		List linkedList = new LinkedList<String>();
		linkedList.remove(1);
		return head;
	}

	/**
	 * 删除下一下元素
	 */
	private static ListNode removeNext(ListNode node) {
		if (node == null || node.next == null) {
			return null;
		}
		ListNode p = node.next;
		node.next = node.next.next;
		p.next = null;
		return p;
	}

	/**
	 * add元素
	 */
//	private static ListNode removeNext(ListNode head, ListNode newNode) {
//		head = head.next;
////		while ()
//
//	}



	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{4, 2, 1, 3, 5});
		ListNode listNode = removeNext(head);
		System.out.println("=====");
		ListNodeUtil.println(listNode);
		System.out.println("=====");
		ListNodeUtil.println(head);
	}
}
