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
public class IsFlipedStringV3 {

	/**
	 * 参考题解:
	 * 长度相等时，若s2是s1旋转而成的，那么把s2和自身拼接一次，s1就会出现在其中
	 * "erbottlewat" + "erbottlewat" = erbottle waterbottle wat
	 * 如果s2不是s1旋转而成的，那么那么把s2和自身拼接一次，s1就肯定不会出现在其中
	 *
	 * 作者：zui-weng-jiu-xian
	 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci/solution/xiang-xi-by-zui-weng-jiu-xian/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	public boolean isFlipedString(String s1, String s2) {
		// 长度不相等，肯定不符合要求
		if (s1.length() != s2.length()) {
			return false;
		}

		// 长度相等时，若s2是s1旋转而成的，那么把s2和自身拼接一次，s1就会出现在其中
		// "erbottlewat" + "erbottlewat" = erbottle waterbottle wat
		// 如果s2不是s1旋转而成的，那么那么把s2和自身拼接一次，s1就肯定不会出现在其中
		return (s2 + s2).indexOf(s1) != -1;
	}

	public static void main(String[] args) {
		String str = "123545";

		System.out.println(str.lastIndexOf("2"));
		System.out.println(str.substring(str.lastIndexOf("2")));
	}
}
