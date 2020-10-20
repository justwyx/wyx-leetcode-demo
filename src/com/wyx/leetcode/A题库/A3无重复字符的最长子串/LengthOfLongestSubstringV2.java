package com.wyx.leetcode.A题库.A3无重复字符的最长子串;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

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
public class LengthOfLongestSubstringV2 {

	/**
	 * 有了V1暴力破解的经验，V1效率太低的原因就是重复的操作太多了，得想办法减少这种不必要的重复工作
	 * 想想其实没必要每次都从头开始匹配
	 * 例：abcabcbb
	 * 第一次匹配到abc 第四个字符了a,重复了，我可以记录一下这时的最大长方度，然后将a去掉，继续用bca往下匹配
	 * 这样只需要循环一遍即可得到结果，说干就干
	 */
	public int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		// 用于校验是否遇到重复值
		Set<Character> set = new HashSet<>();
		// 队列保存走过的字符
		Queue<Character> queue = new LinkedBlockingDeque<>();
		// 定义最大长度
		int maxLength = 0;
		// 当前字符
		char curChar;
		// 被队列弹出的字符
		char pollChar;
		for (int i = 0; i < chars.length; i++) {
			// 在队列中添加一个元素
			curChar = chars[i];
			queue.add(curChar);
			// 添加到set中，校验是否有重复
			if (set.add(curChar)) {
				continue;
			}
			// 有重复字符了，获取当前最在不重复字符长度，由于queue里面有一个重复的字符，计算的时候需要减1
			maxLength = Math.max(maxLength, queue.size() - 1);
			// 此时需要弹出与队列中与当前字符相同的字符之前的所有字符，包括当前字符
			do {
				// 弹出并删除头字符
				pollChar = queue.poll();
				// 头字符和当前字符不一样，将该头符在set集合中删除，并继续执行弹出操作
				if (curChar != pollChar) {
					set.remove(pollChar);
				}
			} while (curChar != pollChar);
		}
		// 有可能存在aab这种没有收尾的情况
		return Math.max(maxLength, queue.size());
	}

	public static void main(String[] args) {

		System.out.println(new LengthOfLongestSubstringV2().lengthOfLongestSubstring("abcabbdad") == 3);
		System.out.println(new LengthOfLongestSubstringV2().lengthOfLongestSubstring("abb") == 2);
		System.out.println(new LengthOfLongestSubstringV2().lengthOfLongestSubstring("bba") == 2);
		System.out.println(new LengthOfLongestSubstringV2().lengthOfLongestSubstring("ohomm") == 3);
		System.out.println(new LengthOfLongestSubstringV2().lengthOfLongestSubstring("abc") == 3);
	}
}
