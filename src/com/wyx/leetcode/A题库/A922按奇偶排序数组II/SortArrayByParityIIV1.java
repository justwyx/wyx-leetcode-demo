package com.wyx.leetcode.A题库.A922按奇偶排序数组II;

/**
 * @author : Just wyx
 * @Description : TODO 2020/11/12
 * @Date : 2020/11/12
 */
public class SortArrayByParityIIV1 {
	public int[] sortArrayByParityII(int[] A) {
		int[] a = new int[A.length/2];
		int[] b = new int[A.length/2];
		int aIndex = 0,bIndex = 0;
		for (int i : A) {
			if((i & 1) == 0) {
				b[bIndex++] = i;
			} else {
				a[aIndex++] = i;
			}
		}
		aIndex = 0;
		bIndex = 0;
		for (int i = 0; i < A.length; i++) {
			if ((i & 1) == 0) {
				A[i] = b[bIndex++];
			} else {
				A[i] = a[aIndex++];
			}
		}
		return A;
	}
}
