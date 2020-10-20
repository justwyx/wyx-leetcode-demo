package com.wyx.leetcode.B面试经典.B6字符串压缩;

/**
 * @Description :
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/17
 */
public class CompressStringV1 {
	/**
	 * 依次比较
	 *
	 */
	public String compressString(String S) {
		if (S == null || S.equals("")) {
			return S;
		}
		StringBuilder sb = new StringBuilder();
		char lastChar = S.charAt(0);
		int num = 0;
		for (int i = 1; i < S.length(); i++) {
			++num;
			if (lastChar == S.charAt(i)) {
				continue;
			}
			sb.append(lastChar).append(num);
			lastChar = S.charAt(i);
			num = 0;
		}
		// 最后的字符没有添加，这里补上
		sb.append(lastChar).append(++num);
		return sb.length() >= S.length()? S : sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new CompressStringV1().compressString("aabcccccaa"));
	}
}
