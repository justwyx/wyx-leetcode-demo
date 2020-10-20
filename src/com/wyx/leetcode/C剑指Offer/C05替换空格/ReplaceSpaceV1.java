package com.wyx.leetcode.C剑指Offer.C05替换空格;

/**
 * @Description :
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @author : Just wyx
 * @Date : 2020/9/28
 */
public class ReplaceSpaceV1 {
	/**
	 * 先获取字符串中空格的数量，以便计算出新字符串数组的长度
	 * @param s
	 * @return
	 */
	public String replaceSpace(String s) {
		// 记录空格数量
		int spaceNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (' ' == s.charAt(i)) {
				spaceNum++;
			}
		}
		// s.length() + spaceNum * 2 新字符串数组的长度
		char[] newStr = new char[s.length() + spaceNum * 2];
		int newStrIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			if (' ' == s.charAt(i)) {
				newStr[newStrIndex++] = '%';
				newStr[newStrIndex++] = '2';
				newStr[newStrIndex++] = '0';
			} else {
				newStr[newStrIndex++] = s.charAt(i);
			}
		}
		return new String(newStr);
	}
}
