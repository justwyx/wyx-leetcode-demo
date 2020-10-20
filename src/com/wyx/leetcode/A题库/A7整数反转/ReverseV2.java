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
public class ReverseV2 {

	/**
	 * V1版本用list保存本身就很浪费空间，这个版本想办法将list去掉
	 * 其实也不需要用list保存，直接用结果集保存就行了
	 * 例：123
	 * 第一次获取到第一位 3
	 * 将 3加入result,result = 3
	 * 第二次获取第二位 2
	 * 将 3 * 10 + 2 = 32
	 * 第三次将32 * 10 + 1 = 321
	 * 反转结束
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		// 1位数反转就是自己
		if (x > -10 && x < 10) {
			return x;
		}
		// 用long类型来接收
		long result = 0;
		while (x != 0) {
			result = result * 10 + (x % 10);
			x /= 10;
		}
		// 超过long类型的边界则返回0
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) result;
	}


	public static void main(String[] args) {
		System.out.println("1:" + new ReverseV2().reverse(1));
		System.out.println("187:" + new ReverseV2().reverse(187));
		System.out.println("-187:" + new ReverseV2().reverse(-187));
		System.out.println("Integer.MAX_VALUE:" + new ReverseV2().reverse(Integer.MAX_VALUE));
	}

}
