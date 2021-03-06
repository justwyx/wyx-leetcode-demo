package com.wyx.leetcode.A题库.A129求根到叶子节点数字之和;

import com.wyx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description :
 * 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * @author : Just wyx
 * @Date : 2020/10/29
 */
public class SumNumbersV1 {

	public int sumNumbers(TreeNode root) {
		List<String> nums = new ArrayList<>();
		String num = "";
		sumNumbers(root, nums, num);
		int result = 0;
		for (String numStr : nums) {
			result += Integer.valueOf(numStr);
		}
		return result;
	}

	private void sumNumbers(TreeNode root, List<String> nums, String num) {
		if (root == null) {
			return;
		}
		num += root.val;
		if (root.left == null && root.right == null) {
			nums.add(num);
		}
		sumNumbers(root.left, nums, num);
		sumNumbers(root.right, nums, num);
	}
}
