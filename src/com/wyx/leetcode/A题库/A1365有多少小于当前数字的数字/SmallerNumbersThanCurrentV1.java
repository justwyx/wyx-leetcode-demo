package com.wyx.leetcode.A题库.A1365有多少小于当前数字的数字;

import java.util.Arrays;

/**
 * @Description :
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 * @author : Just wyx
 * @Date : 2020/10/26
 */
public class SmallerNumbersThanCurrentV1 {
	public static int[] smallerNumbersThanCurrent(int[] nums) {
		// 记录数字出现的次数
		int[] numArray = new int[101];
		for (int num : nums) {
			numArray[num] += 1;
		}
		// 记录小于当前数字前的有多少位
		int[] sums = new int[101];
		sums[0] = numArray[0];
		for (int i = 1; i <= numArray.length; i++) {
			sums[i] = numArray[i] + sums[i - 1];
		}
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num == 0) {
				result[i] = 0;
			} else {
				result[i] = sums[num - 1];
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		int[] nums = {8, 1, 2, 2, 3};
		int[] nums = {5,0,10,0,10,6};
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
	}
}
