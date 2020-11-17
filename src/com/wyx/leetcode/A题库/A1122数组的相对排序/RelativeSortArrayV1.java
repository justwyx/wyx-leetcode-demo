package com.wyx.leetcode.A题库.A1122数组的相对排序;

import java.util.Arrays;

/**
 * @Description :
 * 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * @author : Just wyx
 * @Date : 2020/11/14
 */
public class RelativeSortArrayV1 {
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int index = 0;
		for (int i = 0; i < arr2.length; i++) {
			int val = arr2[i];
			for (int j = index; j < arr1.length; j++) {
				if (val != arr1[j]) {
					continue;
				}
				if (j != index) {
					swap(arr1, index, j);
				}
				index++;
			}
		}
		if (index >= arr1.length - 1) {
			return arr1;
		}
		int[] tem = Arrays.copyOfRange(arr1, index, arr1.length);
		Arrays.sort(tem);
		for (int i = 0; i < tem.length; i++) {
			arr1[i + index] = tem[i];
		}
		return arr1;
	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	public static void main(String[] args) {
//		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19,18};
//		int[] arr2 = {2,1,4,3,9,6};
//		int[] arr1 = {28,6,22,8,44,17};
//		int[] arr2 = {22,28,8,6};
//		System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));

		System.out.println(1 ^ 2);
		System.out.println(1 & 2);
		System.out.println(6 | 1);
	}
}






















