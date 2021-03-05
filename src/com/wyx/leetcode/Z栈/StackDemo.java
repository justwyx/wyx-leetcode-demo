package com.wyx.leetcode.Z栈;

import java.util.Stack;

/**
 * @author : Just wyx
 * @Date : 2021/3/5
 */
public class StackDemo {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("a");
		stack.push("b");
		stack.push("c");

		System.out.println(stack.peek()); // 这里得到栈顶元素'c'
		System.out.println(stack.pop());  // 这里将栈顶元素'c'弹出
		System.out.println(stack.peek()); // 此时栈顶元素为'b'
		System.out.println(stack.pop());  // 这里将栈顶元素'b'弹出
	}
}
