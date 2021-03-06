package com.wyx.leetcode.L链表练习.L2链表中环的检测;

import com.wyx.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description :
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *  
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/24
 */
public class HasCycleV1 {
	/**
	 * hash表法
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while (head != null) {
			if (!set.add(head)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

}
