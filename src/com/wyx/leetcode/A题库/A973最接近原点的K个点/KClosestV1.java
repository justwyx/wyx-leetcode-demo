package com.wyx.leetcode.A题库.A973最接近原点的K个点;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : Just wyx
 * @Description : TODO 2020/11/9
 * @Date : 2020/11/9
 */
public class KClosestV1 {
	public int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
		return Arrays.copyOfRange(points, 0, K);
	}
}
