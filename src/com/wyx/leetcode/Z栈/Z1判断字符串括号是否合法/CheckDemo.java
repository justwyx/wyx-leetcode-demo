package com.wyx.leetcode.Z栈.Z1判断字符串括号是否合法;

import java.util.Stack;

/**
 * 题目】字符串中只有字符'('和')'。合法字符串需要括号可以配对。比如：
 * <p>
 * 输入："()"
 * <p>
 * 输出：true
 * <p>
 * 解释：()，()()，(())是合法的。)(，()(，(()是非法的。
 * <p>
 * 请你实现一个函数，来判断给定的字符串是否合法。
 * <p>
 * boolean isValid(String s);
 *
 * @author : Just wyx
 * @Date : 2021/3/5
 */
public class CheckDemo {

//	public static boolean isValid(String s) {
//		// 当字符串本来就是空的时候，我们可以快速返回true
//		if (s == null || s.length() == 0) {
//			return true;
//		}
//		// 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
//		if (s.length() % 2 == 1) {
//			return false;
//		}
//		// 消除法的主要核心逻辑:
//		Stack<Character> t = new Stack<>();
//		for (int i = 0; i < s.length(); i++) {
//			// 取出字符
//			char c = s.charAt(i);
//			if (c == '(') {
//				// 如果是'('，那么压栈
//				t.push(c);
//			} else if (c == ')') {
//				// 如果是')'，那么就尝试弹栈
//				if (t.empty()) {
//					// 如果弹栈失败，那么返回false
//					return false;
//				}
//				t.pop();
//			}
//		}
//		return t.empty();
//	}

	/**
	 * 栈中元素都相同时，实际上没有必要使用栈，只需要记录栈中元素个数。
	 */
	public static boolean isValid(String s) {
		// 当字符串本来就是空的时候，我们可以快速返回true
		if (s == null || s.length() == 0) {
			return true;
		}
		// 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
		if (s.length() % 2 == 1) {
			return false;
		}
		// 消除法的主要核心逻辑:
		int leftBraceNumber = 0;
		for (int i = 0; i < s.length(); i++) {
			// 取出字符
			char c = s.charAt(i);
			if (c == '(') {
				// 如果是'('，那么压栈
				leftBraceNumber++;
			} else if (c == ')') {
				// 如果是')'，那么就尝试弹栈
				if (leftBraceNumber <= 0) {
					// 如果弹栈失败，那么返回false
					return false;
				}
				--leftBraceNumber;
			}
		}
		return leftBraceNumber == 0;
	}

	public static void main(String[] args) {
		System.out.println(isValid("()()()((()))"));
		System.out.println(isValid("()()()((())))"));
		System.out.println(isValid(""));
		System.out.println(isValid("("));
	}
}
