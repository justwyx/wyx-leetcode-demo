package com.wyx.leetcode.A题库.A7整数反转;

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
public class ReverseV3 {

	/**
	 * V3版本参考 弹出和推入数字 & 溢出前进行检查
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		// 1位数反转就是自己
		if (x > -10 && x < 10) {
			return x;
		}
		int result = 0;
		int num;
		while (x != 0) {
			num = x % 10;
			// 检查是否会越界
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) {
				return 0;
			}
			if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num < -8)) {
				return 0;
			}
			result = result * 10 + num;
			x /= 10;
		}
		return result;
	}


	public static void main(String[] args) {
		System.out.println("1:" + new ReverseV3().reverse(1));
		System.out.println("187:" + new ReverseV3().reverse(187));
		System.out.println("-187:" + new ReverseV3().reverse(-187));
		System.out.println("Integer.MAX_VALUE:" + new ReverseV3().reverse(Integer.MAX_VALUE));
	}

}
