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
public class LongestPalindromeV3 {

	/**
	 * 一直对这个回文串迷迷糊糊的，看了官方的解析顿时感觉豁然开朗
	 * 引用leecode原话：
	 * 对于一个子串而言，如果它是回文串，并且长度大于 22，那么将它首尾的两个字母去除之后，它仍然是个回文串。
	 * 例如对于字符串 “ababa”，如果我们已经知道 “bab” 是回文串，那么 “ababa” 一定是回文串，这是因为它的首尾两个字母都是“a”。
	 * 看到官方有三种方式
	 * 1.动态规划
	 * 2.中心扩展算法
	 * 3.Manacher算法
	 * 文字太多，先按自己想到的来实现一下，可能会和中心扩展的思路会比较像
	 * 每次循环都将 p(i,i) 与 p（i,i + 1)进行扩散，直至护展到不匹配为止
	 */
	public String longestPalindrome(String s) {
		// 提前退出
		if (s.length() < 2) {
			return s;
		}
		int len = s.length();
		int start = 0;
		int maxLength = 0;
		// 临时长度
		int length;
		// 临时扩展次数
		int diffusionNum;
		for (int i = 0; i < len - 1; i++) {
			diffusionNum = getDiffusionNum(s, i - 1, i + 1);
			if (diffusionNum > 0) {
				length = diffusionNum * 2 + 1;
				if (length > maxLength) {
					start = i - diffusionNum;
					maxLength = length;
				}
			}

			diffusionNum = getDiffusionNum(s, i, i + 1);
			if (diffusionNum > 0) {
				length = diffusionNum * 2;
				if (length > maxLength) {
					start = i - diffusionNum + 1;
					maxLength = length;
				}
			}
		}
		maxLength = maxLength == 0? 1: maxLength;
		return s.substring(start, start + maxLength);
	}

	/**
	 * 获取扩展次数
	 */
	private int getDiffusionNum(String s, int i, int j) {
		// 扩展次数
		int num = 0;
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			num++;
			i--;
			j++;
		}
		return num;
	}


	public static void main(String[] args) {
		System.out.println(new LongestPalindromeV3().longestPalindrome("babad"));
		System.out.println(new LongestPalindromeV3().longestPalindrome("cbbd"));
		System.out.println(new LongestPalindromeV3().longestPalindrome("abc"));
		System.out.println(new LongestPalindromeV3().longestPalindrome(""));
		System.out.println(new LongestPalindromeV3().longestPalindrome("ac"));
		System.out.println(new LongestPalindromeV3().longestPalindrome("ccc"));
		System.out.println(new LongestPalindromeV3().longestPalindrome("abcda"));
		System.out.println(new LongestPalindromeV3().longestPalindrome("bb"));
	}
}
