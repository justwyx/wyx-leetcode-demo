package com.wyx.leetcode.A题库.A303区域和检索_数组不可变;

/**
 * @author : Just wyx
 * @Description : TODO 2020/10/22
 * @Date : 2020/10/22
 */
public class NumArrayV4 {
	/**
	 * 1 2 3 4 5
	 * 1 3 6 10 15
	 */
	private int [] sum;

	public NumArrayV4(int[] nums) {
		sum = new int[nums.length];
		if (nums.length == 0) {
			return;
		}
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = nums[i] + sum[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return sum[j];
		}
		return sum[j] - sum[i - 1];
	}

}
