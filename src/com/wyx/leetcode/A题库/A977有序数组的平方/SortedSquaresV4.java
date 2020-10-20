package com.wyx.leetcode.A题库.A977有序数组的平方;

import java.util.Arrays;

/**
 * @Description : TODO 2020/10/16
 * @author : Just wyx
 * @Date : 2020/10/16
 */
public class SortedSquaresV4 {
	/**
	 * 获取第一个大于等于0的位置，分别平方获取两个新数组，然后在合并成完整的数组
	 */
	public static int[] sortedSquares(int[] A) {
		// 获取第一个大于等于0的位置
		int plusIndex = A.length;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 0) {
				plusIndex = i;
				break;
			}
		}
		int[] a = new int[plusIndex];
		int index = 0;
		for (int i = plusIndex - 1; i >= 0; i--) {
			a[index++] = A[i] * A[i];
		}

		index = 0;
		int[] b = new int[A.length - plusIndex];
		for (int i = plusIndex; i < A.length; i++) {
			b[index++] = A[i] * A[i];
		}
		// 合并
		index = 0;
		int aIndex = 0;
		int bIndex = 0;
		while (aIndex < a.length && bIndex < b.length) {
			if (a[aIndex] < b[bIndex]) {
				A[index++] = a[aIndex++];
			} else {
				A[index++] = b[bIndex++];
			}
		}
		if (aIndex < a.length) {
			for (int i = aIndex; i < a.length; i++) {
				A[index++] = a[i++];
			}
		}
		if (bIndex < b.length) {
			for (int i = bIndex; i < b.length; i++) {
				A[index++] = b[i];
			}
		}
		return A;
	}

	public static void main(String[] args) {
		int[] ints ={ 0,2 };
		System.out.println(Arrays.toString(sortedSquares(ints)));
	}
}
