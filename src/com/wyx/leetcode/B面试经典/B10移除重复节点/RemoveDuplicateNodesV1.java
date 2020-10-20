package com.wyx.leetcode.B面试经典.B10移除重复节点;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description :
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/18
 */
public class RemoveDuplicateNodesV1 {
	public ListNode removeDuplicateNodes(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		Set<Integer> set = new HashSet<>();
		set.add(head.val);

		ListNode pos = head;

		while (pos.next != null) {
			ListNode cur = pos.next;
			if (set.add(cur.val)) {
				pos = pos.next;
			} else {
				pos.next = pos.next.next;
			}
		}
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(2);

		head = new RemoveDuplicateNodesV1().removeDuplicateNodes(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}



