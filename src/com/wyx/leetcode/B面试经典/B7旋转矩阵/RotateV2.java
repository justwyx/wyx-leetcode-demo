package com.wyx.leetcode.B面试经典.B7旋转矩阵;

/**
 * @Description :
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/17
 */
public class RotateV2 {

	/**
	 * 参考解题：对角线翻转
	 *作为例子，先将其通过水平轴翻转得到：
	 *
	 *  5  1  9 11                 15 14 12 16
	 *  2  4  8 10                 13  3  6  7
	 * ------------   =水平翻转=>   ------------
	 * 13  3  6  7                  2  4  8 10
	 * 15 14 12 16                  5  1  9 11
	 *
	 * 再根据主对角线 \backslash\ 翻转得到：
	 *
	 *
	 * 15 14 12 16                   15 13  2  5
	 * 13  3  6  7   =主对角线翻转=>   14  3  4  1
	 *  2  4  8 10                   12  6  8  9
	 *  5  1  9 11                   16  7 10 11
	 *
	 */
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// 水平翻转
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < n; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = temp;
			}
		}
		// 主对角线翻转
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
