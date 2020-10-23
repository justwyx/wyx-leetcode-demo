package com.wyx.leetcode.A题库.A234回文链表;

import com.wyx.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author : Just wyx
 * @Date : 2020/10/23
 */
public class IsPalindromeV2 {
	private ListNode linshi;

	public boolean isPalindrome(ListNode head) {
		linshi = head;
		return recursivelyCheck(head);
	}

	private boolean recursivelyCheck(ListNode cur) {
		if (cur != null) {
			if (!recursivelyCheck(cur.next)) {
				return false;
			}
			if (cur.val != linshi.val) {
				return false;
			}
			linshi = linshi.next;
		}
		return true;
	}
}
