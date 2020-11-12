package com.wyx.leetcode.A题库.A922按奇偶排序数组II;

import java.util.Arrays;

/**
 * @author : Just wyx
 * @Description : TODO 2020/11/12
 * @Date : 2020/11/12
 */
public class SortArrayByParityIIV2 {
	public static int[] sortArrayByParityII(int[] A) {
		int n = A.length;
		int j = 1;
		for (int i = 0; i < n; i += 2) {
			if ((A[i] & 1) == 1) {
				while ((A[j] & 1) == 1) {
					j += 2;
				}
				swap(A, i, j);
			}
		}
		return A;
	}

	private static void swap(int[] A, int i, int j) {
		A[i] = A[i] ^ A[j];
		A[j] = A[i] ^ A[j];
		A[i] = A[i] ^ A[j];
	}

	public static void main(String[] args) {
		int[] A = {4,2,5,7};
		System.out.println(Arrays.toString(sortArrayByParityII(A)));
	}
}
