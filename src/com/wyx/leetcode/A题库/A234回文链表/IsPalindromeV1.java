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
public class IsPalindromeV1 {
	public boolean isPalindrome(ListNode head) {
		List<Integer> headList = new ArrayList<>();
		while (head != null) {
			headList.add(head.val);
			head = head.next;
		}
		int i = 0;
		int j = headList.size() - 1;
		while (i < j) {
			if (!headList.get(i).equals(headList.get(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
