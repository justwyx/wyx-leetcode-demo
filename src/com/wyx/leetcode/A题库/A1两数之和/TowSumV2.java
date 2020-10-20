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
public class TowSumV2 {

	/**
	 * 原v1版本
	 */
	public int[] twoSumV1(int[] nums, int target) {
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

	/**
	 * 假设没有负数的情况，可以先将大于目标的数字排除掉，用一个数组记录比目标值小的数字的下标
	 * 后续循环这个下标数组进行匹配
	 * 在目标值较小的情况下能提升效率
	 * 注意取值时需要先将下标数据的值取出来，在去原数组中取数字
	 *
	 * 注: LeetCode不支持该版本，会用带有负数的数据去测试
	 */
	public int[] twoSum(int[] nums, int target) {
		// 保存记录数据值比 target 小的值坐标
		int[] lowIndexArray = new int[nums.length];
		int lowIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			// 考虑有为0的数值,只有大于目标的值才过滤
			if (nums[i] > target) {
				continue;
			}
			lowIndexArray[lowIndex++] = i;
		}
		// 如果没有去掉任何数字，继续走V1
		if (lowIndex == nums.length) {
			return twoSumV1(nums, target);
		}
		// 没有答案
		if (lowIndex == 0) {
			return null;
		}

		// 截取lowIndexArray
		int[] copy = new int[lowIndex];
		System.arraycopy(lowIndexArray, 0, copy, 0,lowIndex);
		return twoSum(lowIndexArray, nums, target);
	}

	/**
	 * @param indexs 坐标数据
	 * @param nums 原数据数据
	 * @param target 目标值
	 * @return
	 */
	public int[] twoSum(int[] indexs, int[] nums, int target) {
		// 记录目标值与第一个加数的差值
		int difference;
		// 这里循环的是坐标
		for (int i = 0; i < indexs.length; i++) {
			// 这里需要先获取到下标值，在去原数据取得真实数据
			difference = target - nums[indexs[i]];
			for (int j = 0; j < indexs.length; j++) {
				// 同一个数只能用一次，遇到相同的跳过
				if (i == j) {
					continue;
				}
				if (nums[indexs[j]] == difference) {
					int[] result = {indexs[i], indexs[j]};
					return result;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TowSumV2 towSumV2 = new TowSumV2();
		int[] nums = {2, 7, 11, 15};
		System.out.println("twoSumV2：" + Arrays.toString(towSumV2.twoSum(nums, 9)));
	}

}
