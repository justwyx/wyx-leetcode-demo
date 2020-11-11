package com.wyx.leetcode.A题库.A67二进制求和;

/**
 * @Description :
 * 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * @author : Just wyx
 * @Date : 2020/11/11
 */
public class AddBinaryV2 {
	/**
	 * 1111 1111
	 * 1111
	 *
	 * 11110
	 */
	public static String addBinary(String a, String b) {
		StringBuffer ans = new StringBuffer();

		int n = Math.max(a.length(), b.length()), carry = 0;
		for (int i = 0; i < n; ++i) {
			carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
			carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
			ans.append((char) (carry % 2 + '0'));
			carry /= 2;
		}

		if (carry > 0) {
			ans.append('1');
		}
		ans.reverse();

		return ans.toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("1111", "1"));
//		System.out.println(addBinary("11", "1"));
//		System.out.println(addBinary("10", "1"));
	}
}
