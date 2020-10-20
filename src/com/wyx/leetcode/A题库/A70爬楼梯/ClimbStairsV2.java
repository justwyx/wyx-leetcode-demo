package com.wyx.leetcode.A题库.A70爬楼梯;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @author : Just wyx
 * @Date : 2020/9/27
 */
public class ClimbStairsV2 {
	private static Map<Integer, Integer> mapCache = new HashMap<>();

	/**
	 * 动态规化
	 * f(0) = 1
	 * f(1) = 1
	 * f(2) = 2
	 * f(3) = 3
	 * f(4) = 5
	 * f(5) = 8
	 * n的结果总等于前两数结果相加
	 */
	public int climbStairs(int n) {
		if (n <= 3) {
			return n;
		}
		int two = 2, three = 3, result = 0;
		for (int i = 3; i < n; i++) {
			result = two + three;
			two = three;
			three = result;
		}
		return result;
	}
}
