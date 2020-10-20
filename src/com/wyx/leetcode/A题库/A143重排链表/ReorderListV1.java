package com.wyx.leetcode.A题库.A143重排链表;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @author : Just wyx
 * @Date : 2020/10/20
 */
public class ReorderListV1 {
	public static void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		List<ListNode> listNode = new ArrayList<>();
		ListNode tem = head;
		while (tem != null) {
			listNode.add(tem);
			tem = tem.next;
		}
		int iIndex = 1;
		int jIndex = listNode.size() - 1;
		tem = head;
		while (iIndex <= jIndex) {
			tem.next = listNode.get(jIndex--);
			tem = tem.next;
			if (iIndex <= jIndex) {
				tem.next = listNode.get(iIndex++);
				tem = tem.next;
			}
		}
		tem.next = null;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{1, 2, 3, 4, 5});
		reorderList(head);
		ListNodeUtil.println(head);
	}
}
