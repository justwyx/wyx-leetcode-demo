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
public class ClimbStairsV1 {
	private static Map<Integer, Integer> mapCache = new HashMap<>();

	/**
	 * 递归实现
	 * 注：递归需要添加缓存机制，不然重复计算太多了
	 * f(n) = f(n-1) + f(n-2)
	 * n <= 2,return 2
	 */
	public int climbStairs(int n) {
		if (n <= 3) {
			return n;
		}
		if (mapCache.get(n) != null) {
			return mapCache.get(n);
		}
		int num = climbStairs(n -1) + climbStairs(n -2);
		mapCache.put(n, num);
		return num;
	}
}
