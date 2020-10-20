package com.wyx.leetcode.A题库.A3无重复字符的最长子串;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
@SuppressWarnings("all")
public class LengthOfLongestSubstringV1 {

	/**
	 * 暴力破解版
	 * 通过循环遍列的方式一个个字符开始去匹配
	 * 最开始由第一个字符开始向后走，遇到重复的字符停止，获取长度
	 * 继续从第二个字符开始匹配，直到匹配完获取最大长度
	 */
	public int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		// 用于校验是否遇到重复值
		Set<Character> set;
		// 定义最大长度
		int maxLength = 0;
		for (int i = 0; i < chars.length; i++) {
			// 剩下的总长度比当前获取的最大长度小，则没必要在执行下去了
			if (s.length() - 1 < maxLength) {
				return maxLength;
			}
			set = new HashSet<>();
			int j = i;
			for (; j < s.length(); j++) {
				if (!set.add(chars[j])) {
					maxLength = Math.max(maxLength, j - i);
					break;
				}
			}
			// 没有遇到重复字条跳出的情况
			if (j >= s.length()) {
				maxLength = Math.max(maxLength, s.length() - i);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(new LengthOfLongestSubstringV1().lengthOfLongestSubstring("abcabbdad"));
		System.out.println(new LengthOfLongestSubstringV1().lengthOfLongestSubstring("abb"));
		System.out.println(new LengthOfLongestSubstringV1().lengthOfLongestSubstring("bba"));
		System.out.println(new LengthOfLongestSubstringV1().lengthOfLongestSubstring("ohomm"));
		System.out.println(new LengthOfLongestSubstringV1().lengthOfLongestSubstring("abc"));
	}
}
