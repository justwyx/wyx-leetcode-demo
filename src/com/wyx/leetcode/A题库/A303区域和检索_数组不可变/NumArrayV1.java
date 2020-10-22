package com.wyx.leetcode.A题库.A303区域和检索_数组不可变;

/**
 * @author : Just wyx
 * @Description : TODO 2020/10/22
 * @Date : 2020/10/22
 */
public class NumArrayV1 {
	int[] nums;
	public NumArrayV1(int[] nums) {
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		int result = 0;
		for (; i <= j; i++) {
			result += nums[i];
		}
		return result;
	}
}
