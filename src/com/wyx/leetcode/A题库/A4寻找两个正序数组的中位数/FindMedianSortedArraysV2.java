package com.wyx.leetcode.A题库.A4寻找两个正序数组的中位数;

/**
 * @Description :
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author : Just wyx
 * @Date : 2020/8/13
 */
@SuppressWarnings("all")
public class FindMedianSortedArraysV2 {


	/**
	 * V2版本想继续优化的点就是在两个数组极不平衡的时候
	 * 例：num1[1,3,4,5,7,9,11,13,15,17,19,.....]
	 * 	  num2[2]
	 * 的时候，其实不需要继续向下循环，可以快速的获取结果，不过代码实现可能会更复杂，可读性会变差，
	 * 暂时没有好的方式实现，V2版本先暂停
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		/**
		 * 两个数数组不会同时为空,只有一个数组的时候执行效率更高
 		 */
		if (nums1 == null || nums1.length == 0) {
			return findMedianSortedArrays(nums2);
		}
		if (nums2 == null || nums2.length == 0) {
			return findMedianSortedArrays(nums1);
		}
		// 定义两个数组初始下标值
		int numIndex1 = 0, numIndex2 = 0;
		// 总数组长度
		int totalLength = nums1.length + nums2.length;
		// 是否为奇数
		boolean isOddNumber = totalLength % 2 == 1;
		/**
		 * 获取两个中位数的位置,
		 * 如果是积数位，则后续直接返回endIndex
		 * 如果是偶数位，后续返回两个坐标对应值的平均值
		 */
		int endIndex = totalLength/2;
		int startIndex = endIndex - 1;
		int startValue = 0;
		int endValue = 0;

		// 临时变量
		int value;
		for (int i = 0; i <= endIndex; i++) {
			if (numIndex2 >= nums2.length) {
				value = nums1[numIndex1];
				numIndex1++;
			} else if (numIndex1 >= nums1.length) {
				value = nums2[numIndex2];
				numIndex2++;
			} else if (nums1[numIndex1] < nums2[numIndex2]) {
				value = nums1[numIndex1];
				numIndex1++;
			} else {
				value = nums2[numIndex2];
				numIndex2++;
			}

			if (i == startIndex) {
				startValue = value;
			} else if (i == endIndex) {
				endValue = value;
			}
		}
		return isOddNumber? endValue : getAverage(startValue, endValue);
	}

	/**
	 * 有一条数组为空的情况
	 */
	public double findMedianSortedArrays(int[] nums) {
		int index = nums.length / 2;
		/**
		 * 数组长度为奇数，中位数就是中间那个数
		 * 例[1,2,3,4,5]，数组长度为5,index为2，应该取出下标为2的数(3)为中位值
 		 */
		if (nums.length % 2 == 1) {
			return nums[index];
		}
		/**
		 * 数组长度为偶数，
		 * 例[1,2,3,4]，数组长度为4,index为2，应该取出下标为 1，2两个数（2，3），取平均值
 		 */
		return getAverage(nums[index - 1], nums[index]);
	}

	/**
	 * 获取平均值
	 */
	private static double getAverage(int a, int b) {
		return ((double)a + (double)b) / 2;
	}


	public static void main(String[] args) {
		int[] num1 = {1,2};
		int[] num2 = {3,4};

		System.out.println(new FindMedianSortedArraysV2().findMedianSortedArrays(num1, num2));
	}
}
