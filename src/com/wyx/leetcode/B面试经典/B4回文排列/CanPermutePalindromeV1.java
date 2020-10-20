package com.wyx.leetcode.B面试经典.B4回文排列;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description :
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/8/20
 */
public class CanPermutePalindromeV1 {

	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) {
				set.remove(s.charAt(i));
			}
		}

		return set.size() < 2? true : false;
	}

	public static void main(String[] args) {
		System.out.println(new CanPermutePalindromeV1().canPermutePalindrome("AaBb//a"));
	}
}
