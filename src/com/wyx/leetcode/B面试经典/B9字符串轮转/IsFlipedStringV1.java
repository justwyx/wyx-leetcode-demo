package com.wyx.leetcode.B面试经典.B9字符串轮转;

/**
 * @Description :
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/18
 */
public class IsFlipedStringV1 {

	/**
	 * 最容易想到的是每次将字符串最后一位移到前面，然后进行比对，
	 * 不过这种方法不止调用一次检查之串的方法
	 */
	public boolean isFlipedString(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() <= 1) {
			return true;
		}
		int subLength = s1.length() - 1;
		for (int i = 0; i < s1.length(); i++) {
			s2 = s2.substring(subLength) + s2.substring(0, subLength);
			if (s1.equals(s2)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "12345";

		System.out.println(str.substring(4));
		System.out.println(str.substring(0, 4));
	}
}
