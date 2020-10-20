package com.wyx.leetcode.A题库.A8字符串转换整数;

/**
 * @Description :
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 *
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * @author : Just wyx
 * @Date : 2020/8/14
 */
public class MyAtoiV1 {
	/**
	 * 这个题的示例真多，题理清楚了就好解决,总得来说还是逐个字符解析
	 * 1.前面有空格，跳过继续向下解析
	 * 2.前面有字母，退出返回0
	 * 3.正号/负号/数字后面如果不是数字，不继续向下解析
	 *
	 * @param str
	 * @return
	 */
	public int myAtoi(String str) {
		// 最终结果
		int result = 0;
		// 是否为正数
		boolean isPositive = true;
		// 是否退出
		boolean isExit = false;

		// 临时变量保存数字
		int digit;
		for (int i = 0; i < str.length(); i++) {
			// 遇到数字处理数字，提前判断是否越出整数范围
			if (Character.isDigit(str.charAt(i))) {
				digit = str.charAt(i) - 48;
				// 检查是否会越界
				if (isPositive && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7))) {
					return Integer.MAX_VALUE;
				}
				if (!isPositive && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 8))) {
					return Integer.MIN_VALUE;
				}
				result = result * 10 + digit;
				isExit = true;
				continue;
			}
			// 跳出循环
			if (isExit) {
				break;
			}
			// 是否为空格,跳出当前循环
			if (Character.isSpaceChar(str.charAt(i))) {
				continue;
			}
			// 遇到 + 号，后续如果不是遇到连续的数字则退出
			if (str.charAt(i) + 0 == 43) {
				if (isExit) {
					return 0;
				}
				isExit = true;
				continue;
			}
			// 遇到 - 号，后续如果不是遇到连续的数字则退出，同时更新符号位
			if (str.charAt(i) + 0 == 45) {
				if (isExit) {
					return 0;
				}
				isExit = true;
				isPositive = false;
				continue;
			}
			// 遇到其它符号跳出循环
			break;
		}

		return isPositive?result : -result;
	}

	public static void main(String[] args) {


//		System.out.println(new MyAtoiV1().myAtoi("42"));
		System.out.println(new MyAtoiV1().myAtoi("-2147483649"));
		System.out.println(new MyAtoiV1().myAtoi("- 234"));
	}

}
