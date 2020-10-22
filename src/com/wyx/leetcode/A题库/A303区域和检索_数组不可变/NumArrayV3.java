package com.wyx.leetcode.A题库.A303区域和检索_数组不可变;



import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Just wyx
 * @Description : TODO 2020/10/22
 * @Date : 2020/10/22
 */
public class NumArrayV3 {
	private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

	public NumArrayV3(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				map.put(new Pair(i, j), sum);
			}
		}
	}

	public int sumRange(int i, int j) {
		return map.get(new Pair(i, j));
	}

}
