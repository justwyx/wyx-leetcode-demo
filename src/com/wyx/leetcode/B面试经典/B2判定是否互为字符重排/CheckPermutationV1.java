package com.wyx.leetcode.B面试经典.B2判定是否互为字符重排;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
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
public class CheckPermutationV1 {

	/**
	 * 这题的主体思路就是校验两个字符串中的每个字符出现的次数是否全一致，V1继续走简单粗暴的方式
	 * 1.将其中一个字符串的字符以Map<字符，出现的次数>的形式维护到map集合中
	 * 2.遍例另外一个字符，校验字符是否出现，出现就对map数据进行次数减少操作，否则提前匹配失败
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

		// 将s2的字符维护到map中
		// Map<字符，出现的次数>
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			// 字符第一次出现，初始化到map中
			if (!map.containsKey(s2.charAt(i))) {
				map.put(s2.charAt(i), 1);
				continue;
			}
			map.put(s2.charAt(i), map.get(s2.charAt(i)) + 1);
		}
		Integer num;
		for (int i = 0; i < s1.length(); i++) {
			if (!map.containsKey(s1.charAt(i))) {
				return false;
			}
			num = map.get(s1.charAt(i));
			if (num.equals(1)) {
				map.remove(s1.charAt(i));
				continue;
			}
			map.put(s1.charAt(i), map.get(s1.charAt(i)) - 1);
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "asvnpzurz", s2 = "urzsapzvn";
		System.out.println(new CheckPermutationV1().CheckPermutation(s1, s2));
	}
	
	
	
}
