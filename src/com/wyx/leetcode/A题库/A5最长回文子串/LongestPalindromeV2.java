package com.wyx.leetcode.A题库.A5最长回文子串;

/**
 * @Description :
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author : Just wyx
 * @Date : 2020/8/13
 */
@SuppressWarnings("all")
public class LongestPalindromeV2 {

	/**
	 * V3版本参考一官方的中心扩展法代码
	 * 将两种扩散的后的处理逻辑做了合并，获了长度时还考虑了为负数的情况，很强大，后面遇到这种类型的问题不知道能不能灵活运用上
	 */
	public String longestPalindrome(String s) {
		// 提前退出
		if (s.length() < 2) {
			return s;
		}
		int start = 0, end = 0, len;
		for (int i = 0; i < s.length(); i++) {
			len = Math.max(getLen(s, i, i), getLen(s, i, i+1));
			// 屏蔽了两种实现的复杂度
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	/**
	 * 获取长度
	 */
	private int getLen(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		// 还考虑了负数的情况
		return end - start - 1;
	}


	public static void main(String[] args) {
		System.out.println(new LongestPalindromeV2().longestPalindrome("babad"));
		System.out.println(new LongestPalindromeV2().longestPalindrome("cbbd"));
		System.out.println(new LongestPalindromeV2().longestPalindrome("abc"));
		System.out.println(new LongestPalindromeV2().longestPalindrome(""));
		System.out.println(new LongestPalindromeV2().longestPalindrome("ac"));
		System.out.println(new LongestPalindromeV2().longestPalindrome("ccc"));
		System.out.println(new LongestPalindromeV2().longestPalindrome("abcda"));
		System.out.println(new LongestPalindromeV2().longestPalindrome("bb"));
	}
}
