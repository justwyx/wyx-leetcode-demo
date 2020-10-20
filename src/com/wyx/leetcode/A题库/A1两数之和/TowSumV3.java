package com.wyx.leetcode.A题库.A1两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class TowSumV3 {

	/**
	 * 根据官方两遍hash表的思路，自己写的版本
	 */
	public int[] twoSum(int[] nums, int target) {
		// 用一个Map来保存数字与下标的对照关系
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>(getMapSizeBySize(nums.length));
		for (int i = 0; i < nums.length; i++) {
			numMap.put(nums[i], i);
		}

		int difference;
		for (int i = 0; i < nums.length; i++) {
			difference = target - nums[i];
			if (numMap.get(difference) != null && i != numMap.get(difference)) {
				return new int[] {i, numMap.get(difference)};
			}
		}
		return null;
	}

	/**
	 * 获取map初始化的值的大小
	 */
	public static int getMapSizeBySize(int size) {
		return size * 4 / 3 + 2;
	}


	public static void main(String[] args) {
		TowSumV3 towSum = new TowSumV3();
		int[] nums = {2, 7, 11, 15};
		System.out.println("twoSum：" + Arrays.toString(towSum.twoSum(nums, 9)));
	}

}
