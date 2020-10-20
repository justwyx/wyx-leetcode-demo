package com.wyx.leetcode.A题库.A5最长回文子串;

import java.util.*;

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
public class LongestPalindromeV1 {

	/**
	 * 开始觉得这题和题3.无重复字符的最长子串一样，甚至更简单，以为只需要找到两个最长的重复的字符，然后截取出中间的字符返回就行了
	 * 结果是一开始就误解了其回文串的意思，导致修改提交了几次都错了
	 *
	 * 回文的意思是正着念和倒着念一样，如：上海自来水来自海上
	 * 对应的最长回文串示例:
	 *   "babad" ==> bab
	 *   "" ==> ""
	 *   "ac" ==> a
	 *   "ccc" ==> ccc
	 *   "abcda" ==> a
	 *
	 * 后续知道回文串的用意后，想到的是最长回文串其实最主要的还是要看是否有重复的字符，
	 * 然后校验最是否满足回文串的要求，如果满足就直接截取字符串返回
	 * 没有满足的则按没有满足的退出
	 * 1.首先维护的是一个大顶堆，里面保存的是带有重复的字符的起始位置数组
	 * 2.依次取出大顶堆中维护的数组，去校验是否满足回文串要求，对于相同长度的回文串，随便返回哪个都行
	 */
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		// map用于维护 char字符与它出现过的下标位置
		Map<Character, List<Integer>> map = new HashMap<>();
		// 大顶堆
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(10, Comparator.comparingInt(o -> (o[0] - o[1])));

		// 临时list
		List<Integer> list;
		for (int i = 0; i < s.length(); i++) {
			// 第一次出现，添加进map就退出
			if (!map.containsKey(s.charAt(i))) {
				list = new ArrayList<>(2);
				list.add(i);
				map.put(s.charAt(i), list);
				continue;
			}

			// 获取历史list
			list = map.get(s.charAt(i));
			for (Integer index : list) {
				// 有重复的情况，将出现的位置分别写入到大顶推中
				maxHeap.add(new int[] {index, i});
			}
			list.add(i);
		}
		int[] poll;
		while (maxHeap.size() > 0) {
			poll = maxHeap.poll();
			if (checkLongestPalindrome(s, poll[0], poll[1])) {
				// 由于是前闭后开，end + 1
				return s.substring(poll[0], poll[1] + 1);
			}
		}
		return s.substring(0,1);
	}

	/**
	 * 校验是否满足回文串要求
	 */
	public boolean checkLongestPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}


	public static void main(String[] args) {
		System.out.println(new LongestPalindromeV1().longestPalindrome("babad").equals("bab"));
		System.out.println(new LongestPalindromeV1().longestPalindrome("cbbd").equals("bb"));
		System.out.println(new LongestPalindromeV1().longestPalindrome("abc").equals("a"));
		System.out.println(new LongestPalindromeV1().longestPalindrome("").equals(""));
		System.out.println(new LongestPalindromeV1().longestPalindrome("ac").equals("a"));
		System.out.println(new LongestPalindromeV1().longestPalindrome("ccc").equals("ccc"));
		System.out.println(new LongestPalindromeV1().longestPalindrome("abcda").equals("a"));
	}
}
