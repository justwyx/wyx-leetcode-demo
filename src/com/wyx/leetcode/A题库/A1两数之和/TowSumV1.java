package com.wyx.leetcode.A题库.A1两数之和;

import java.util.Arrays;

/**
 * @Description : 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author : Just wyx
 * @Date : 2020/8/11
 */
public class TowSumV1 {

	/**
	 * 拿到题目,先不参考任何人的代码与解题思路
	 * 双重循环暴力破解
	 */
	public int[] twoSum(int[] nums, int target) {
		// 记录目标值与第一个加数的差值
		int difference;
		int i = 0, j;
		for (; i < nums.length; i++) {
			difference = target - nums[i];
			j = 0;
			for (; j < nums.length; j++) {
				// 同一个数只能用一次，遇到相同的跳过
				if (i == j) {
					continue;
				}
				if (nums[j] == difference) {
					return new int[] {i, j};
				}
			}
		}
		// 没有找到
		return null;
	}


	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		System.out.println("twoSum：" + Arrays.toString(new TowSumV1().twoSum(nums, 9)));
	}

}
