package com.wyx.leetcode.A题库.A303区域和检索_数组不可变;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Just wyx
 * @Description : TODO 2020/10/22
 * @Date : 2020/10/22
 */
public class NumArrayV2 {
	int[] nums;
	private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
	public NumArrayV2(int[] nums) {
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		Integer result = map.get(new Pair<>(i, j));
		if (result != null) {
			return result;
		}
		result = 0;
		for (; i <= j; i++) {
			result += nums[i];
		}
		map.put(new Pair<>(i, j), result);
		return result;
	}
}
