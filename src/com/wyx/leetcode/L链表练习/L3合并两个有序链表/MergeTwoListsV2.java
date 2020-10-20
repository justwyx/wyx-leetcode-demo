package com.wyx.leetcode.L链表练习.L3合并两个有序链表;

import com.wyx.leetcode.common.ListNode;
import com.wyx.leetcode.utils.ListNodeUtil;

/**
 * @Description :
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/24
 */
public class MergeTwoListsV2 {
	/**
	 * 递归的方式
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = ListNodeUtil.build(new int[]{1, 2, 4});
		ListNode l2 = ListNodeUtil.build(new int[]{1, 3, 4});
		ListNode l3 = mergeTwoLists(l1, l2);
		ListNodeUtil.println(l3);
	}
}
