package com.wyx.leetcode.A题库.A7整数反转;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * @author : Just wyx
 * @Date : 2020/8/14
 */
@SuppressWarnings("all")
public class ReverseV1 {

	/**
	 * V1版本简单暴力，将整数反转到list中，在按位累加，不过效率是硬伤
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		// 1位数反转就是自己
		if (x > -10 && x < 10) {
			return x;
		}
		// 会浪费空间
		List<Integer> list = new ArrayList<>(32);
		while (x != 0) {
			list.add(x % 10);
			x /= 10;
		}
		// 用long类型来接收
		long result = 0;
		for (int i = list.size() - 1, j = 0; i >= 0; i--,j++) {
			result += list.get(i) * Math.pow(10, j);
		}
		// 超过long类型的边界则返回0
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) result;
	}


	public static void main(String[] args) {
		System.out.println("1:" + new ReverseV1().reverse(1));
		System.out.println("187:" + new ReverseV1().reverse(187));
		System.out.println("-187:" + new ReverseV1().reverse(-187));
		System.out.println("Integer.MAX_VALUE:" + new ReverseV1().reverse(Integer.MAX_VALUE));
	}

}
