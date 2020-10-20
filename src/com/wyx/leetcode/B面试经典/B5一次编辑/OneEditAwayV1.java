package com.wyx.leetcode.B面试经典.B5一次编辑;

/**
 * @Description :
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/17
 */
public class OneEditAwayV1 {
	/**
	 * 比较两个字符的长度
	 * 1、两个字符长度相差一位，校验长的字符删除一位是否能满足相同让两个字符
	 * 2、两个字符相同，校验是否只有一个字符不同
	 * 3、其它情况提前失败
	 */
	public boolean oneEditAway(String first, String second) {
		int length = first.length() - second.length();
		switch (length) {
			case 0:
				return checkSame(first, second);
			case 1:
				return checkDifferent(second, first);
			case -1:
				return checkDifferent(first, second);
		}
		return false;
	}

	/**
	 * 校验长度相同的符能否满足要求
	 */
	private boolean checkSame(String first, String second) {
		// 记录不同的数量
		int num = 0;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				++num;
			}
		}
		return num <= 1;
	}

	/**
	 * 校验长度相差1的符能否满足要求
	 */
	private boolean checkDifferent(String min, String max) {
		int i = 0;
		int j = 0;
		for (;i < min.length();i++, j++) {
			if (min.charAt(i) != max.charAt(j)
					&& (j != i || min.charAt(i) != max.charAt(++j))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String first = "mart";
		String second = "karma";
		System.out.println(first.substring(2));
		System.out.println(new OneEditAwayV1().checkDifferent(first, second));
	}
}
