package com.wyx.leetcode.A题库.A977有序数组的平方;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description :
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * @author : Just wyx
 * @Date : 2020/9/25
 */
public class SortedSquaresV2 {
	/**
	 * 遍例A并计算平方值，放入小顶堆中
	 * 在些基础上，如果第一个值大于等于0，则直接赋值即可
	 */
	public int[] sortedSquares(int[] A) {
		if (A[0] >= 0) {
			return min0(A);
		}
		int[] B = new int[A.length];
		Queue<Integer> minQueue = new PriorityQueue(A.length);
		for (int i = 0; i < A.length; i++) {
			minQueue.add(A[i] * A[i]);
		}
		for (int i = 0; i < A.length; i++) {
			B[i] = minQueue.poll();
		}
		return B;
	}

	private int[] min0(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}
		return A;
	}
}
