package com.wyx.leetcode.B面试经典.B8零矩阵;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description :
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/17
 */
public class SetZeroesV1 {

	/**
	 * 获取0出现的x,y的位置，然后进行赋值
	 */
	public void setZeroes(int[][] matrix) {
		// 分别记录 x行和y列需要置为0的记录
		Set<Integer> xRow = new HashSet<>();
		Set<Integer> yRow = new HashSet<>();
		int x = matrix.length;
		int y = matrix[0].length;

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (matrix[i][j] == 0) {
					xRow.add(i);
					yRow.add(j);
				}
			}
		}
		for (Integer xIndex : xRow) {
			for (int i = 0; i < y; i++) {
				matrix[xIndex][i] = 0;
			}
		}
		for (Integer yIndex : yRow) {
			for (int i = 0; i < x; i++) {
				matrix[i][yIndex] = 0;
			}
		}
	}
}
