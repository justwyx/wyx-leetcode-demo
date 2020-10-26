package com.wyx.leetcode.D初级算法_数组.D5只出现一次的数字;

import java.util.Arrays;

/**
 * @Description :
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/10/26
 */
public class SingleNumberV1 {
	public int singleNumber(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		return nums[0] != nums[1]? nums[0] : nums[nums.length - 1];
	}
}
