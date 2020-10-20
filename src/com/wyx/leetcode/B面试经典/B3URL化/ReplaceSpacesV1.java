package com.wyx.leetcode.B面试经典.B3URL化;

/**
 * @Description
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（
 * 注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例1:
 *  输入："Mr John Smith    ", 13
 *  输出："Mr%20John%20Smith"
 *
 * 示例2:
 *  输入："               ", 5
 *  输出："%20%20%20%20%20"
 *
 * 提示：
 * 字符串长度在[0, 500000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : Just wyx
 * @Date : 2020/8/18
 */
public class ReplaceSpacesV1 {

	/**
	 * 这题主要是要将[空格]转换成[%20],且知道字符的长度，且java需要用字符数组实现
	 * v1解题思路
	 * 1，定义一个已知道长度的数组
	 * 2，依次获取字符串中的字符，获取到空格就在数组相应位置添加 [%20]，否则将原字符添加到数组中
	 * 3，将数组转成string
	 */
	public String replaceSpaces(String s, int length) {
		String[] strArray = new String[length];
		for (int i = 0; i < length; i++) {
			if (' ' == s.charAt(i)) {
				strArray[i] = "%20";
				continue;
			}
			strArray[i] = String.valueOf(s.charAt(i));
		}
		StringBuilder sb = new StringBuilder(length);
		for (String str : strArray) {
			sb.append(str);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new ReplaceSpacesV1().replaceSpaces("Mr John Smith    ", 13));
		System.out.println(new ReplaceSpacesV1().replaceSpaces("               ", 5));
	}
}

