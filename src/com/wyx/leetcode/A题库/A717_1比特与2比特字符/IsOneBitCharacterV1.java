package com.wyx.leetcode.A题库.A717_1比特与2比特字符;

/**
 * @author : Just wyx
 * @Description : TODO 2020/10/16
 * @Date : 2020/10/16
 */
public class IsOneBitCharacterV1 {
	public static boolean isOneBitCharacter(int[] bits) {
		int n = bits.length;
		if (n <= 1) {
			return true;
		}
		if (bits[n - 2] == 0) {
			return true;
		}
		// 获取除最后一个0，后面全是1的最大长度
		int num = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (bits[i] == 1) {
				num++;
			} else {
				break;
			}
		}
		return num % 2 == 1;
	}

	public static void main(String[] args) {
		int[] a = {0,1,0};
		System.out.println(isOneBitCharacter(a));
	}
}
