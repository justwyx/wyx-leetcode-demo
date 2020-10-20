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
public class IsUniqueV2 {

	/**
	 * 不使用额外的数据结构，那就用数组吧，考虑字符只有字母的情况
	 * 字母A对应char code为65
	 * 字母z对应char code为122
	 * 定义一个大小为58的的数组，默认全填充为-1
	 * 每获取一个字符，添加进数组中，填充时如果值不为-1则说明重复了
	 * @param astr
	 * @return
	 */
	public boolean isUnique(String astr) {
		if (astr == null || "".equals(astr)) {
			return true;
		}
		char A = 'A';
		int[] array = {
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1
		};
		int num;
		for (int i = 0; i < astr.length(); i++) {
			num = astr.charAt(i) - A;
			if (array[num] != -1) {
				return false;
			}
			array[num] = num;
		}
		return true;
	}

	public static void main(String[] args) {
//		System.out.println(new IsUniqueV2().isUnique("leetcode"));
//		System.out.println(new IsUniqueV2().isUnique("abc"));
		System.out.println(new IsUniqueV2().isUnique("kzwunahkiz"));
	}


}
