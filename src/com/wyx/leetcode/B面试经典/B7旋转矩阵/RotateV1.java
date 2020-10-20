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
public class RotateV1 {

	/**
	 * 看题目，这个矩阵应该是正方形矩阵，定义一个中转字符
	 * 0, 0 ==> 0, 3
	 * 0, 1 ==> 1, 3
	 * 0, 2 ==> 2, 3
	 * 0, 3 ==> 3, 3
	 *
	 * 1, 1 ==> 1, 2
	 * 1, 2 ==> 2, 2
	 * 总结：x, y ==> y, convert(x)
	 *
	 * 0, 3 ==> 3, 3
	 * 1, 3 ==> 3, 2
	 * 2, 3 ==> 3, 1
	 * 3, 3 ==> 3, 0
	 *
	 * 2，3 ==> 3, 3
	 * 总结：x, y ==> y, convert(x)
	 *
	 * 3, 3 ==> 3, 0
	 * 3, 2 ==> 2, 0
	 * 3, 1 ==> 1, 0
	 * 3, 0 ==> 0, 0
	 *
	 * 2, 2 ==> 2, 1
	 * 总结：x, y ==> y, convert(x)
	 *
	 * 3, 0 ==> 0, 0
	 * 2, 0 ==> 0, 1
	 * 1, 0 ==> 0, 2
	 * 0, 0 ==> 0, 3
	 *
	 * 2, 1 ==> 1, 1
	 * 总结：x, y ==> y, convert(x)
	 *
	 * j 1, get(i) 3 ==>  get(i) 3, get(j) 2
	 * get(i) 3, get(j) 2 ==> get(j) 2,
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int length = matrix.length;
		int maxIndex = length - 1;
		int rotateNum = length / 2;

		int value;

		int j, x, y, z;
		for (int i = 0; i < rotateNum; i++) {
			for (j = i; j <= maxIndex - i - 1; j++) {
				x = i;
				y = j;
				for (int k = 1; k < 4; k++) {
					value = matrix[i][j];
					matrix[i][j] = matrix[y][convert(maxIndex, x)];
					// x, y ==> y, convert(x)
					z = y;
					y = convert(maxIndex, x);
					x = z;
					matrix[x][y] = value;
				}
			}
		}
	}

	/**
	 * 转换下标
	 */
	private int convert(int maxIndex, int index) {
		return maxIndex - index;
	}


	public static void main(String[] args) {
		int[][] matrix = {
				{5, 1, 9,11},
				{2, 4, 8,10},
				{13, 3, 6, 7},
				{15,14,12,16}
		};
		new RotateV1().rotate(matrix);
		println(matrix);

	}

	private static void println(int[][] matrix) {
		for (int m = 0; m < matrix.length; m++) {
			int[] matrix1 = matrix[m];
			for (int i = 0; i < matrix1.length; i++) {
				System.out.print(matrix1[i] + " ");
			}
			System.out.println();
		}
	}
}
