package com.wyx.leetcode.A题库.A6Z字形变换;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author : Just wyx
 * @Date : 2020/8/13
 */
@SuppressWarnings("all")
public class ConvertV2 {
	/**
	 * V2版本是参考官方的按行排序
	 * 简单点说就是，遍例字符串时，我能知道每个字符所在的行
	 * 我先遍例一次，按顺序将字符分别添加至行，最终在将几个行组合起来成为最终的行
	 * 例：
	 * L   C   I   R
	 * E T O E S I I G
	 * E   D   H   N
	 *
	 * 随着字符串的例，行号的变化为 0 1 2 1 0 1 2
	 * 0   0   0
	 * 1 1 1 1 1
	 * 2   2   2
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		// 返回本身
		if (numRows == 1) {
			return s;
		}
		List<StringBuffer> list = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++) {
			list.add(new StringBuffer());
		}
		// 记录当前行
		int cruRow = 0;
		boolean isAdd = false;
		for (int i = 0; i < s.length(); i++) {
			list.get(cruRow).append(s.charAt(i));
			// 第次遇到两端就取反
			if (cruRow == 0 || cruRow == numRows -1) {
				isAdd = !isAdd;
			}
			cruRow += isAdd? 1 : -1;
		}
		// 遍历填充完后，逐行整合在一起返回
		StringBuffer sb = new StringBuffer(s.length());
		for (StringBuffer stringBuffer : list) {
			sb.append(stringBuffer);
		}
		return sb.toString();
	}




	public static void main(String[] args) {

		System.out.println("3：" + new ConvertV2().convert("LEETCODEISHIRING", 3));
		System.out.println("4：" + new ConvertV2().convert("LEETCODEISHIRING", 4));
		System.out.println("5：" + new ConvertV2().convert("LEETCODEISHIRING", 5));
		System.out.println("6：" + new ConvertV2().convert("LEETCODEISHIRING", 6));
		System.out.println("6：" + new ConvertV2().convert("AB", 2));
	}

}
