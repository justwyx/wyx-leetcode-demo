package com.wyx.leetcode.D初级算法_数组.D11旋转图像;

/**
 * @Description :
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
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
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/10/26
 */
public class RotateV1 {
	/**
	 * 00 03
	 * 03 33
	 * 33 30
	 * 30 00
	 *
	 * 01 13
	 * 13 31
	 * 31 10
	 * 10 01
	 * @param matrix
	 */
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int x,y,z;
		for (int i = 0; i < n/2; i++) {
			for (int j = i; j < n - 1; j++) {
				x = i;
				y = j;

				int tag = matrix[i][j];
				int num = matrix.length - (i * 2) - 1;
				for (int k = 0; k < 4; k++) {
					matrix[y][x + num] = matrix[x][y];
					z = y;
					y = x + num;
					x = z;
				}
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{ 5, 1, 9,11},
				{ 2, 4, 8,10},
				{13, 3, 6, 7},
				{15,14,12,16}
		};
		rotate(matrix);
	}
}
