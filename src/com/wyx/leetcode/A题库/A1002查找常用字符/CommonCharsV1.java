package com.wyx.leetcode.A题库.A1002查找常用字符;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description :
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * @author : Just wyx
 * @Date : 2020/10/14
 */
public class CommonCharsV1 {

	/**
	 *
	 */
	public static List<String> commonChars(String[] A) {
		List<String> result = new ArrayList<>();
		List<HashMap<Character, Integer>> build = build(A);
		String s = A[0];
		HashMap<Character, Integer> numMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			numMap.put(s.charAt(i), 0);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			Integer num = numMap.get(c);
			num += 1;
			numMap.put(c, num);

			boolean flag = true;
			for (HashMap<Character, Integer> characterIntegerHashMap : build) {
				Integer integer = characterIntegerHashMap.get(c);
				if (integer == null || integer < num) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result.add(String.valueOf(c));
			}
		}
		return result;
	}

	private static List<HashMap<Character, Integer>> build (String[] A) {
		List<HashMap<Character, Integer>> result = new ArrayList<>(A.length);
		for (String s : A) {
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				Integer integer = map.get(c);
				if (integer == null) {
					integer = 1;
				} else {
					integer += 1;
				}
				map.put(c, integer);
			}
			result.add(map);
		}
		return result;
	}

	public static void main(String[] args) {
		String[] a = {"cool","lock","cook"};
		System.out.println(commonChars(a));
	}
}
