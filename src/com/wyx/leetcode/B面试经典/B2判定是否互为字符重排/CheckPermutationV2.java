package com.wyx.leetcode.B面试经典.B2判定是否互为字符重排;

/**
 * @Description :
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/8/18
 */
public class CheckPermutationV2 {

	/**
	 * v1版本基础上进行优化，思路还是保持一致，就是校验两个字符串中的每个字符出现的次数是否全一致
	 * 这次不用map了，改在数组来记录出现的次数，思路大概是
	 * 1，先初始化一个数组，值全初始化为0
	 * 2，同时遍例两个字符对象，将字符根据char值减去A，s1中字符出现一次，相应的位置进行加1，s2则是减1
	 * 3，遍历数组，看到有值非0的提前返回匹配失败，否则匹配成功
	 */
	public boolean CheckPermutation(String s1, String s2) {
		// 提前校验两字符长度是否一致
		if (s1.length() != s2.length()) {
			return false;
		}
		// 提前校验两个字符是否一致
		if (s1.equals(s2)) {
			return true;
		}
		char A = 'A';
		int[] array = {
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0
		};
		for (int i = 0; i < s1.length(); i++) {
			array[s1.charAt(i) - A]++;
			array[s2.charAt(i) - A]--;
		}
		for (int num : array) {
			if (num != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "asvnpzurz", s2 = "urzsapzvn";
		System.out.println(new CheckPermutationV2().CheckPermutation(s1, s2));
	}
	
	
	
}
