package com.wyx.leetcode.A题库.A5最长回文子串;

/**
 * @author : Just wyx
 * @Description :
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * @Date : 2020/8/13
 */
@SuppressWarnings("all")
public class LongestPalindromeV4 {

	/**
	 *
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		// 保存起始位置，测试了用数组似乎能比全局变量稍快一点
		int[] range = new int[2];
		char[] str = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			// 把回文看成中间的部分全是同一字符，左右部分相对称
			// 找到下一个与当前字符不同的字符
			i = findLongest(str, i, range);
		}
		return s.substring(range[0], range[1] + 1);
	}

	public static int findLongest(char[] str, int low, int[] range) {
		// 查找中间部分
		int high = low;
		while (high < str.length - 1 && str[high + 1] == str[low]) {
			high++;
		}
		// 定位中间部分的最后一个字符
		int ans = high;
		// 从中间向左右扩散
		while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
			low--;
			high++;
		}
		// 记录最大长度
		if (high - low > range[1] - range[0]) {
			range[0] = low;
			range[1] = high;
		}
		return ans;
	}

	public static void main(String[] args) {
//		System.out.println(new LongestPalindromeV4().longestPalindrome("babad"));
		System.out.println(new LongestPalindromeV4().longestPalindrome("cbbdbb"));
//		System.out.println(new LongestPalindromeV4().longestPalindrome("abc"));
//		System.out.println(new LongestPalindromeV4().longestPalindrome(""));
//		System.out.println(new LongestPalindromeV4().longestPalindrome("ac"));
//		System.out.println(new LongestPalindromeV4().longestPalindrome("ccc"));
//		System.out.println(new LongestPalindromeV4().longestPalindrome("abcda"));
//		System.out.println(new LongestPalindromeV4().longestPalindrome("bb"));
	}
}
