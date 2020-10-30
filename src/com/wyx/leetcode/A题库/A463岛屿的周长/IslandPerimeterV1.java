package com.wyx.leetcode.A题库.A463岛屿的周长;

/**
 * @Description :
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 * @author : Just wyx
 * @Date : 2020/10/30
 */
public class IslandPerimeterV1 {
	public int islandPerimeter(int[][] grid) {
		int length = 0;
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				if (grid[x][y] == 1) {
					length += getLength(grid, x, y);
				}
			}
		}
		return length;
	}

	/**
	 * 获取当前陆地暴露出来的长度，分别计划上下左右四面的长度，哪边有陆地则不计算长度
	 * @param grid
	 * @param x
	 * @param y
	 * @return
	 */
	private int getLength(int[][] grid, int x, int y) {
		int length = 0;
		// 上
		if (x == 0 || grid[x - 1][y] == 0) {
			length++;
		}
		// 下
		if (x == grid.length - 1 || grid[x + 1][y] == 0) {
			length++;
		}
		// 左
		if (y == 0 || grid[x][y - 1] == 0) {
			length++;
		}
		// 右
		if (y == grid[0].length - 1 || grid[x][y + 1] == 0) {
			length++;
		}
		return length;
	}
}
