package com.wyx.leetcode.A题库.A6Z字形变换;

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
public class ConvertV3 {
	/**
	 * V3版本参数参考官方的 按行访问，不过官方的是用StringBuilder，我觉得用数组会更好
	 * 以4行为例
	 * 首先只看整体部分，步长为6
	 * L     D     R
	 * E   O E   I I
	 * E C   I H   N
	 * T     S     G
	 * 下标                 步长
	 * 0     6       12    6
	 * 1     7       13    6
	 * 2     8       14    6
	 * 3     9       15    6
	 *
	 * 在看完整的
	 * 0     6       12
	 * 1   5 7    11 13
	 * 2 4   8 10    14
	 * 3     9       15
	 * 其实只有在非首尾行时，每两个数中间会多夹带一个数，用这个数的步长也是有规律的
	 * 按照这种思想自己在实现一下
	 *
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		// 返回本身
		if (numRows == 1) {
			return s;
		}
		int strLength = s.length();
		// 依旧使用数组保存最终结果
		char[] chars = new char[strLength];
		int charIndex = 0;

		// 步长
		int length = numRows + numRows - 2;
		// 第一个循环循环行
		for (int i = 0; i < numRows; i++) {
			// 第二个循环获限当前行的字符
			for (int j = 0; i + j < strLength; j += length) {
				// 这里获取的是上面整体部分的值
				chars[charIndex++] = s.charAt(i + j);
				// 首行和尾行没有多余的字符,超过字符长度也过滤
				if (i == 0 || i == numRows - 1 || j + length - i >= strLength) {
					continue;
				}
				/**
				 * 例：像上面所说行数为4时，j总是在 0 6 12中进行变化
				 * 而中间的值总是相对于在 1 6 12的基础上， -1 -2的值
				 */
				chars[charIndex++] = s.charAt(j + length - i);
			}
		}
		return String.valueOf(chars);
	}




	public static void main(String[] args) {

//		System.out.println("3：" + new ConvertV3().convert("LEETCODEISHIRING", 3));
//		System.out.println("4：" + new ConvertV3().convert("LEETCODEISHIRING", 4));
//		System.out.println("5：" + new ConvertV3().convert("LEETCODEISHIRING", 5));
//		System.out.println("6：" + new ConvertV3().convert("LEETCODEISHIRING", 6));
//		System.out.println("6：" + new ConvertV3().convert("AB", 2));
//		System.out.println("6：" + new ConvertV3().convert("PAYPALISHIRING", 3));
		System.out.println("6：" + new ConvertV3().convert("PAYPALISHIRING", 4));
	}

}
