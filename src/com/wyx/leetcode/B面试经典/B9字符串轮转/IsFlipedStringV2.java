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
public class IsFlipedStringV2 {

	/**
	 * 在第一个版本的基础上进行优化，校验字符最后一次出现的位置，然后从那里开始截取，减少截取次数
	 * 注：不会出现两个字符串相同的情况
	 */
	public boolean isFlipedString(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() <= 1) {
			return true;
		}
		while (true) {
			int lastIndex = s2.lastIndexOf(s1.charAt(0));
			if (lastIndex <= 0) {
				return false;
			}
			s2 = s2.substring(lastIndex) + s2.substring(0, lastIndex);
			if (s1.equals(s2)) {
				return true;
			}
		}
	}

	public static void main(String[] args) {
		String str = "123545";

		System.out.println(str.lastIndexOf("2"));
		System.out.println(str.substring(str.lastIndexOf("2")));
	}
}
