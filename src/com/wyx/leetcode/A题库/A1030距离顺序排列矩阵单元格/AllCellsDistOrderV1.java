package com.wyx.leetcode.A题库.A1030距离顺序排列矩阵单元格;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : Just wyx
 * @Description : TODO 2020/11/17
 * @Date : 2020/11/17
 */
public class AllCellsDistOrderV1 {
	public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] ret = new int[R * C][];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ret[i * C + j] = new int[]{i, j};
			}
		}
		Arrays.sort(ret, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
			}
		});
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(allCellsDistOrder(2,3,1, 2)));
	}
}
