package com.wyx.leetcode.A题库.A977有序数组的平方;

import java.util.Arrays;

/**
 * @Description : TODO 2020/10/16
 * @author : Just wyx
 * @Date : 2020/10/16
 */
public class SortedSquaresV5 {
	/**
	 * 从两头进行平方比较
	 */
	public static int[] sortedSquares(int[] A) {
		int[] result = new int[A.length];
		int index = A.length - 1;
		for (int i = 0, j = A.length - 1; i <= j;) {
			if (A[i] * A[i] > A[j] * A[j]) {
				result[index--] = A[i] * A[i];
				i++;
			} else {
				result[index--] = A[j] * A[j];
				j--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] ints ={ 0,2 };
		System.out.println(Arrays.toString(sortedSquares(ints)));
	}
}
