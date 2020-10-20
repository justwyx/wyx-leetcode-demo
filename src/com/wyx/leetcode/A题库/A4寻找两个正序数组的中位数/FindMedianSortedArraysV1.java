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
public class FindMedianSortedArraysV1 {


	/**
	 * 既然有是序的那就好办了,题目说了不会同时为空，就说明可能会有一个为空的情况
	 * 所以可分为两种情况进行
	 * 1，有一个数组为空的情况
	 * 	 描述在下面
	 * 2, 两个数组都不为空
	 *    两个数组都不为空且有序，先获取两个数据的总长度算出中位数出现的位置(总长度/2)
	 *    例：num1[1,3,5],num2[2],这时总长度为4
	 *    num1[1,3,5],num2[2,4],这时总长度为5
	 *    不管是哪种形式，我们都是循环取两个数组中的值去比对，值更小的数组下标向后滑动一位
	 *    最终都去获取下标为 (总长度/2)和(总长度/2 - 1) 下标的值
	 *    如
	 *    	第一对数组我们取出值 [2，3]
	 *      第二对数组我们取出值 [2，3]
	 *    由于一第组数组总长度为偶数，对我们将取这两个数的平均值(2.5)进行返回
	 *    第二组为奇数，我们直接返回后面那个值(即3)
	 *    注意：要考虑边界情况，小心数组越界
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

		System.out.println(new FindMedianSortedArraysV1().findMedianSortedArrays(num1, num2));
	}
}
