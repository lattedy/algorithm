package leetcode.medium.SurroundedRegions130;

import java.util.*;

public class Solution {
	static int[][] visit;
	static boolean[] groupFlag;
	static int group, m, n;
	static void fill(char[][] map, int r, int c) {
		visit[r][c] = group;
		if (r-1 < 0) groupFlag[group] = false;
		else if (map[r-1][c] == 'O' && visit[r-1][c] == 0) fill(map, r-1, c);

		if (r+1 >= m) groupFlag[group] = false;
		else if (map[r+1][c] == 'O' && visit[r+1][c] == 0) fill(map, r+1, c);

		if (c-1 < 0) groupFlag[group] = false;
		else if (map[r][c-1] == 'O' && visit[r][c-1] == 0) fill(map, r, c-1);

		if (c+1 >= n) groupFlag[group] = false;
		else if (map[r][c+1] == 'O' && visit[r][c+1] == 0) fill(map, r, c+1);
	}
	public static void solve(char[][] board) {
		m = board.length;
		n = board[0].length;
		visit = new int[m][n];
		groupFlag = new boolean[((m*n) >> 1) + 1];
		Arrays.fill(groupFlag, true);

		group = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O' && visit[i][j] == 0) {
					fill(board, i, j);
					group++;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] > 0 && groupFlag[visit[i][j]]) {
					board[i][j] = 'X';
				}
				System.out.printf("%c", board[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[][] input = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(input);
	}
}
