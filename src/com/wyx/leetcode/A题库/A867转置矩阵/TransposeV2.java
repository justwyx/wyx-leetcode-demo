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
public class TransposeV2 {

	/**
	 * 参考官方题解
	 * 方法：直接复制
	 * 思路和算法
	 *
	 * 尺寸为 R x C 的矩阵 A 转置后会得到尺寸为 C x R 的矩阵 ans，对此有 ans[c][r] = A[r][c]。
	 *
	 * 让我们初始化一个新的矩阵 ans 来表示答案。然后，我们将酌情复制矩阵的每个条目。
	 *
	 * 作者：LeetCode
	 * 链接：https://leetcode-cn.com/problems/transpose-matrix/solution/zhuan-zhi-ju-zhen-by-leetcode/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	public int[][] transpose(int[][] A) {
		int xLength = A.length;
		int yLength = A[0].length;
		int[][] B = new int[yLength][xLength];
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {
				B[y][x] = A[x][y];
			}
		}
		return B;
	}
}
