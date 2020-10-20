package com.wyx.leetcode.P排序算法.P1选择排序;

import java.util.Arrays;

/**
 * @author : Just wyx
 * @Description : TODO 2020/9/29
 * @Date : 2020/9/29
 */
public class SelectionSortV2 {
	/**
	 * 定义二个指针，第次对数组进行循环，取得最小值与最大值
	 * 然后将最小值与第一位进行更换，最大值与最后一位更换
	 * @param array 入参
	 * @return
	 */
	public static void sort(int[] array) {
		int minIndex;
		int maxIndex;
		for (int i = 0; i < array.length - i; i++) {
			minIndex = i;
			maxIndex = i;
			int j = i + 1;
			for (; j < array.length - i; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
				if (array[j] >= array[maxIndex]) {
					maxIndex = j;
				}
			}
			if (i != minIndex) {
				int tmp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = tmp;
			}
			if (array.length - i - 1 != maxIndex) {
				int tmp = array[array.length - i - 1];
				array[array.length - i - 1] = array[maxIndex];
				array[maxIndex] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {5,3,4,2,8,1,9};
		sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println("------------");

//		int[] array1 = {1};
//		sort(array1);
//		System.out.println(Arrays.toString(array1));
	}

}
