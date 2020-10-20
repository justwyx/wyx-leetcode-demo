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
public class IsPalindromeV1 {

	/**
	 * 这题一看就知道最少两种解法，先用第一种解法试试水，转成string然后进行对比
	 * 首先要知道的是
	 * 1.负数肯定不是回文数
	 * 2.个位数肯定是回文数
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		} else if (x < 10) {
			return true;
		}
		String xStr = String.valueOf(x);
		int lentgh = xStr.length() - 1;
		// 比较两头的数是否相同
		for (int i = 0; i <= lentgh/2; i++) {
			if (xStr.charAt(i) != xStr.charAt(lentgh - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new IsPalindromeV1().isPalindrome(121));
		System.out.println(new IsPalindromeV1().isPalindrome(123));
		System.out.println(new IsPalindromeV1().isPalindrome(-121));
		System.out.println(new IsPalindromeV1().isPalindrome(7));


		System.out.println(21 ^ 12);
	}
}
