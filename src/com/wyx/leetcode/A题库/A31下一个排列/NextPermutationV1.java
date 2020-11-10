package com.wyx.leetcode.A题库.A31下一个排列;

import java.util.Arrays;

/**
 * @Description :
 * 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @author : Just wyx
 * @Date : 2020/11/10
 */
public class NextPermutationV1 {
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	private static void swap(int[] nums,int i, int j) {
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public static void reverse(int[] nums, int start) {
		int i = start;
		int j = nums.length - 1;
		for (;i < j; i++,j--) {
			swap(nums, i, j);
		}
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1};
//		int[] nums = {1, 2, 3};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
