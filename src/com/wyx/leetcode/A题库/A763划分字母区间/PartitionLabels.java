package com.wyx.leetcode.A题库.A763划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * @author : Just wyx
 * @Date : 2020/10/22
 */
public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		int[] last = new int[26];
		// 记录字符最后出现的位置
		for (int i = 0; i < S.length(); i++) {
			last[S.charAt(i) - 'a'] = i;
		}
		List<Integer> result = new ArrayList<>();
		int start = 0, end = 0;
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, last[S.charAt(i) - 'a']);
			if (i == end) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		return result;
	}
}
