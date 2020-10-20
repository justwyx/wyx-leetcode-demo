package com.wyx.leetcode.P排序算法.P1选择排序;

import java.util.Arrays;

/**
 * @author : Just wyx
 * @Description : TODO 2020/9/29
 * @Date : 2020/9/29
 */
public class SelectionSortV1 {
	/**
	 * 定义一个指针，第次对数组进行循环，取得最小值，然后将最小值与第一位进行更换
	 * @param array 入参
	 * @return
	 */
	public static void sort(int[] array) {
		int minIndex;
		for (int i = 0; i < array.length - 1; i++) {
			minIndex = i;
			int j = i + 1;
			for (; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				int tmp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {5,3,4,1,2,8,9};
		sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println("------------");

		int[] array1 = {1};
		sort(array1);
		System.out.println(Arrays.toString(array1));
	}

}
