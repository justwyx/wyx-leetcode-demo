package com.wyx.leetcode.B面试经典.B8零矩阵;


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
public class SetZeroesV2 {

	/**
	 * 参考题解：
	 * 步骤如下：
	 * 1、矩阵中某个数为零，则将该数所在行的第一个数置零，所在列的第一个数置零，即matrix[0][j] = matrix[i][0] = 0
	 * 2、遍历上面处理过的首行和首列的每个元素（[0][0]位置除外），如果为零，则说明该行或者该列应该都为零，将该行或列全部元素置零
	 * 3、第一步操作会让首行首列是否有零这个信息损失掉，因为首行首列被用来存储其他信息了，会改变他们的取值，所以再定义两个变量row0,col0记录首行首列是否有零，最后根据row0和col0来处理首行和首列自己
	 *
	 * 作者：jin-ai-yi
	 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci/solution/huo-yong-shou-xing-shou-lie-yuan-su-zuo-wei-gai-xi/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	public void setZeroes(int[][] matrix) {
		boolean xRow = false;
		boolean yRow = false;
		// 首列
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				xRow = true;
			}
		}
		// 首行
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				yRow = true;
			}
		}
		// 遇到为0的时，将首行与首列的值赋值为0
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// 将首列为0的，当前整行都置为0
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				matrix[i] = new int[matrix[0].length];
			}
		}
		// 将首行为0的，当前列转为0
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		// 首行
		if (yRow) {
			matrix[0] = new int[matrix[0].length];
		}
		// 首列
		if (xRow) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][0] = 0;
			}
		}
	}
}
