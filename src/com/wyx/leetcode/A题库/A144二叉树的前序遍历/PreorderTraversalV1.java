package com.wyx.leetcode.A题库.A144二叉树的前序遍历;

import com.wyx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author : Just wyx
 * @Date : 2020/10/27
 */
public class PreorderTraversalV1 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		traversal(root, resultList);
		return resultList;
	}

	public void traversal(TreeNode treeNode, List<Integer> resultList) {
		if (treeNode == null) {
			return;
		}
		resultList.add(treeNode.val);
		traversal(treeNode.left, resultList);
		traversal(treeNode.right, resultList);
	}
}
