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
public class AddBinaryV1 {
	/**
	 * 1111 1111
	 * 1111
	 *
	 * 11110
	 */
	public static String addBinary(String a, String b) {
		// 保证A比较大
		if (a.length() < b.length()) {
			String c = a;
			a = b;
			b = c;
		}
		char[] str = new char[a.length() + 1];
		str[0] = '0';
		for (int i = 0; i < a.length(); i++) {
			str[i+1] = a.charAt(i);
		}
		for (int i = 1; i <= b.length(); i++) {
			char c = b.charAt(b.length() - i);
			if (c == '0') {
				continue;
			}
			for (int j = str.length - i; j >= 0; j--) {
				char c1 = str[j];
				if (c1 == '0') {
					str[j] = '1';
					break;
				}
				str[j] = '0';
			}
		}
		if (str[0] == '0') {
			return new String(str, 1, str.length - 1);
		}
		return new String(str);
	}

	public static void main(String[] args) {
//		System.out.println(addBinary("1010", "1011"));
//		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("10", "1"));
	}
}
