package com.wyx.leetcode.A题库.A349两个数组的交集;

import java.util.*;

/**
 * @Description :
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @author : Just wyx
 * @Date : 2020/11/2
 */
public class IntersectionV1 {
	public static int[] intersection(int[] nums1, int[] nums2) {
		nums1 = duplicateRemoval(nums1);
		nums2 = duplicateRemoval(nums2);
		int newLength = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (contains(nums2, nums1[i])) {
				nums1[newLength++] = nums1[i];
			}
		}
		int[] result = new int[newLength];
		if (newLength > 0) {
			System.arraycopy(nums1,0, result, 0, newLength);
		}
		return result;
	}

	private static int[] duplicateRemoval(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int[] result = new int[set.size()];
		int index = 0;
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			result[index++] = next;
		}
		return result;
	}

	private static boolean contains(int[] nums, int num) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num) {
				return true;
			}
		}
		return false;
	}



	public static void main(String[] args) {
//		List<Integer> a = new ArrayList();
//		List<Integer> b = new ArrayList();
//		a.add(1);
//		a.add(2);
//		b.add(2);
//		a.retainAll(b);
//		System.out.println(a);

		int[] a = {1, 2, 3, 4, 5};
//		int[] b = {2, 4, 5};
		int[] b = {6};
		System.out.println(Arrays.toString(intersection(a, b)));

	}
}
