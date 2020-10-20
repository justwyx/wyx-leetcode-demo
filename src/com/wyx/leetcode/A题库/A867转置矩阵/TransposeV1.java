package com.wyx.leetcode.A题库.A867转置矩阵;

/**
 * @Description :
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 *  
 *
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 1 4 7
 * 2 5 8
 * 3 6 9
 *
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * 1 2 3
 * 4 5 6
 *
 * 1 4
 * 2 5
 * 3 6
 *
 * 提示：
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/transpose-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : Just wyx
 * @Date : 2020/9/25
 */
public class TransposeV1 {

	/**
	 * 先用暴力法，新 new一个二维数组，然后将数据填进去
	 */
	public int[][] transpose(int[][] A) {
		int xLength = A.length;
		int yLength = A[0].length;
		int[][] B = new int[yLength][xLength];
		int xIndex = 0;
		int yIndex = 0;
		for (int i = 0; i < xLength; i++,yIndex++) {
			for (int j = 0; j < yLength; j++) {
				B[xIndex++][yIndex] = A[i][j];
			}
			xIndex = 0;
		}
		return B;
	}
}
