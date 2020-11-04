package com.wyx.leetcode.A题库.A57插入区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 *  插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * @author : Just wyx
 * @Date : 2020/11/4
 */
public class InsertV1 {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		int left = newInterval[0];
		int right = newInterval[1];
		boolean flag = false;
		List<int[]> list = new ArrayList<>();
		for (int[] interval : intervals) {
			if (right < interval[0]) {
				// 在区间左边
				if (!flag) {
					list.add(new int[]{left, right});
					flag = true;
				}
				list.add(interval);
			} else if (left > interval[1]) {
				list.add(interval);
			} else {
				left = Math.min(left, interval[0]);
				right = Math.max(right, interval[1]);
			}
		}
		if (!flag) {
			list.add(new int[]{left, right});
		}
		int[][] result = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4, 8};
		int[][] insert = insert(intervals, newInterval);
		System.out.println("");
	}

}
