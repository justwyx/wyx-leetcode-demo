package com.wyx.leetcode.B面试经典.B1判定字符是否唯一;

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
public class IsUniqueV3 {

	/**
	 * 看了下评论区的实现，V2版本是我理解错了，不使用额外的数据结构是连数组也不能使用
	 * 参考了indexOf解法，一个字符从前向后查找和从后向前查，出现的位置都一样
	 *
	 * @param astr
	 * @return
	 */
	public boolean isUnique(String astr) {
		if (astr == null || "".equals(astr)) {
			return true;
		}
		for (int i = 0; i < astr.length(); i++) {
			if (astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		System.out.println(new IsUniqueV2().isUnique("leetcode"));
//		System.out.println(new IsUniqueV2().isUnique("abc"));
		System.out.println(new IsUniqueV3().isUnique("kzwunahkiz"));
	}


}
