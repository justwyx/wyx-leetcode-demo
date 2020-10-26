package com.wyx.leetcode.D初级算法_数组.D8移动零;

import java.util.Arrays;

/**
 * @Description :
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/10/26
 */
public class MoveZeroesV1 {
	public static void moveZeroes(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				num++;
				continue;
			}
			if (num == 0) {
				continue;
			}
			nums[i - num] = nums[i];
			nums[i] = 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
