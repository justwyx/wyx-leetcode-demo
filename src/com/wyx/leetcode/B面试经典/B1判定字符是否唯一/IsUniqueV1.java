package com.wyx.leetcode.B面试经典.B1判定字符是否唯一;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description :
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 示例 2：
 * 输入: s = "abc"
 * 输出: true
 *
 * 限制：
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author : Just wyx
 * @Date : 2020/8/15
 */
public class IsUniqueV1 {

	/**
	 * 这题一看就很方便实现，一个Set就能解决，
	 * 不过有个限制是不使用额外的数据结构，会很加分，这个留到V2吧
	 * @param astr
	 * @return
	 */
	public boolean isUnique(String astr) {
		if (astr == null || "".equals(astr)) {
			return true;
		}
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < astr.length(); i++) {
			if (!set.add(astr.charAt(i))) {
				return false;
			}
		}
		return true;
	}


}
