package com.wyx.leetcode.A题库.A143重排链表;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Just wyx
 * @Description : TODO 2020/10/20
 * @Date : 2020/10/20
 */
public class ReorderListV2 {
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
		int i = 0;
		int j = listNode.size() - 1;
		while (i < j) {
			listNode.get(i++).next = listNode.get(j);
			if (i == j) {
				break;
			}
			listNode.get(j--).next = listNode.get(i);
		}
		listNode.get(i).next = null;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.build(new int[]{1, 2, 3, 4});
		reorderList(head);
		ListNodeUtil.println(head);
	}
}
