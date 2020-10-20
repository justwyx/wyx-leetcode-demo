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
public class ConvertV1 {
	/**
	 * 最开始看到这题的时候是想弄一个二维数组，根据规律依次将字符串依次填入数组的相应位置，然后遍列输出
	 * 可越想越不对劲，因为只需要我们输出最后的变换过后的字符串，根本不需要我们打印Z字形
	 * 这下就好办了，只需要去找取字符的规
	 * 对于字符串 LEETCODEISHIRING
	 *
	 * 行数为3的时候：
	 * L   C   I   R
	 * E T O E S I I G
	 * E   D   H   N
	 * 下标                  中间间隔的步数
	 * 0   4   8     12     4 4
	 * 1 3 5 7 9  11 13 15  2 2
	 * 2   6   10    14     4 4
	 *
	 * 行数为4的时候：
	 * L     D     R
	 * E   O E   I I
	 * E C   I H   N
	 * T     S     G
	 * 下标              中间间隔的步数
	 * 0     6       12  6 6
	 * 1   5 7    11 13  4 2
	 * 2 4   8 10    14  2 4
	 * 3     9       15  6 6
	 *
	 * 行数为6的时候：
	 * 下标            中间间隔的步数
	 * 0          10  10 10
	 * 1       9  11  8 2
	 * 2     8    12  6 4
	 * 3   7      13  4 6
	 * 4 6        14  2 8
	 * 5          15  10 10
	 *
	 * 规率很好发现，第一列就是 0~numRows，
	 * 间隔的步长可以通过 numRows + numRows - 2 获取到
	 * 头和尾的步长是一样的，从第二行起，步长就等于 步长 - 2 和 2交替变化，
	 * 继续向下走 左边的步长 -= 2，右边步长 += 2
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
		// 用于记录新字串的char数组
		char[] chars = new char[s.length()];
		// 间隔的步长
		int length = numRows + numRows - 2;
		// 新字串的下标
		int charIndex = 0;
		// 记录应该从什么位置取老字串的值
		int index = 0;
		// 遍列的行数
		int row = 0;
		// 左右的间隔数
		int intervalLeft = length, intervalRight = length;
		// 单行的循环次数
		int rowCycleNum = 1;
		while (row < numRows) {
			if (index < s.length()) {
				chars[charIndex++] = s.charAt(index);
				index += rowCycleNum++ % 2 == 1? intervalLeft : intervalRight;
			} else {
				index = ++row;
				// 重置单行的循环次数
				rowCycleNum = 1;
				if (row == 1) {
					intervalLeft = length - 2;
					intervalRight = 2;
				}
				if (row == numRows - 1){
					intervalLeft = length;
					intervalRight = length;
				}
				if (row != 1 && row != numRows - 1){
					intervalLeft -= 2;
					intervalRight += 2;
				}
			}
		}
		return String.valueOf(chars);
	}




	public static void main(String[] args) {

		System.out.println("3：" + new ConvertV1().convert("LEETCODEISHIRING", 3));
		System.out.println("4：" + new ConvertV1().convert("LEETCODEISHIRING", 4));
		System.out.println("5：" + new ConvertV1().convert("LEETCODEISHIRING", 5));
		System.out.println("6：" + new ConvertV1().convert("LEETCODEISHIRING", 6));
		System.out.println("6：" + new ConvertV1().convert("AB", 2));
	}

}
