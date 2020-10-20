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
public class LengthOfLongestSubstringV3 {

	/**
	 * 参考官方版本，官方版本用的是滑动窗口，简洁太多，根本不需要另外用队列来记录字符
	 * 一个map就搞定了，又强又骚
	 */
	public int lengthOfLongestSubstring(String s) {
		// 定义一个map保存字符与坐标信息
		Map<Character, Integer> map = new HashMap<>();
		// 最大长度
		int maxLength = 0;
		int num = s.length();
		int start = -1, end = 0;

		// 当前字符
		char curChar;
		for (; end < num; end++) {
			curChar = s.charAt(end);
			// 校验字符在map中是否存在
			if (map.containsKey(curChar)) {
				// 已存在，则需要将start向后滑动
				start = Math.max(map.get(curChar), start);
			}
			maxLength = Math.max(maxLength, end - start);
			map.put(curChar, end);
		}
		return maxLength;
	}

	public static void main(String[] args) {

		System.out.println(new LengthOfLongestSubstringV3().lengthOfLongestSubstring("abcabbdad") == 3);
		System.out.println(new LengthOfLongestSubstringV3().lengthOfLongestSubstring("abb") == 2);
		System.out.println(new LengthOfLongestSubstringV3().lengthOfLongestSubstring("bba") == 2);
		System.out.println(new LengthOfLongestSubstringV3().lengthOfLongestSubstring("ohomm") == 3);
		System.out.println(new LengthOfLongestSubstringV3().lengthOfLongestSubstring("abc") == 3);
	}
}
