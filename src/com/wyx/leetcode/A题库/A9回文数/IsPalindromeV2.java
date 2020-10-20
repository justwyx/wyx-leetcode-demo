package com.wyx.leetcode.A题库.A9回文数;

/**
 * @Description :
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author : Just wyx
 * @Date : 2020/8/15
 */
public class IsPalindromeV2 {

	/**
	 * V1版本将数字转成字符本身就需要额外的空间，V2版本按要求进阶
	 * 既然是回文数，那么右边翻转过来肯定和左边不是一样的，同时需要考虑数字的长度是奇数位的情况
	 *
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		// 用于记录翻转的值
		int num = 0;
		while (x > num) {
			num = num * 10 + x % 10;
			x /= 10;
		}
		/**
		 * 例：1221
		 * 翻转后x=12,num=12,成功
		 * 例：121
		 * 翻转后x=1,num=12,因为数的长度是奇数位，num需要去掉中间的2才能匹配
		 */
		return num == x || num/10 == x;
	}

	public static void main(String[] args) {
		System.out.println(new IsPalindromeV2().isPalindrome(11));
		System.out.println(new IsPalindromeV2().isPalindrome(121));
		System.out.println(new IsPalindromeV2().isPalindrome(123));
		System.out.println(new IsPalindromeV2().isPalindrome(-121));
		System.out.println(new IsPalindromeV2().isPalindrome(7));


	}
}
