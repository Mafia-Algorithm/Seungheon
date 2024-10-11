import java.util.*;
import java.io.*;

public class BoardCover {

	static int[][] numberBoard;

	static int[][][] blockType = {
		{{0, 0}, {1, 0}, {0, 1}},
		{{0, 0}, {0, 1}, {1, 1}},
		{{0, 0}, {1, 0}, {1, 1}},
		{{0, 0}, {1, 0}, {1, -1}}
	};

	static boolean set(int[][] board, int x, int y, int typeNumber, int delta) {
		boolean ok = true;
		for (int i = 0; i < 3; i++) {
			int nextX = x + blockType[typeNumber][i][0];
			int nextY = y + blockType[typeNumber][i][1];

			// 블럭이 보드 밖으로 나가거나 이미 블럭이 놓여져있는 경우
			if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
				ok = false;
			} else if ((board[nextX][nextY] += delta) > 1) {
				ok = false;
			}
		}

		return ok;
	}

	static int cover(int[][] board) {
		int x = -1;
		int y = -1;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			
				if (x != -1) {
					break;
				}
			}
		}

		// 모든 칸을 채운 경우
		if (x == -1) return 1;

		int ret = 0;
		for (int typeNumber = 0; typeNumber < 4; typeNumber++) {
			if (set(board, x, y, typeNumber, 1)) {
				ret += cover(board);
			}

			set(board, x, y, typeNumber, -1);
		}

		return ret;
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int H = input[0];
			int W = input[1];

			numberBoard = new int[H][W];
			int whiteCount = 0;
			for (int i = 0; i < H; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < W; j++) {
					if (line[j].equals("#")) numberBoard[i][j] = 1;
					else {
						whiteCount++;
						numberBoard[i][j] = 0;
					}
				}
			}

			if (whiteCount % 3 != 0) {
				bw.write("0");
				bw.newLine();
				continue;
			}

			bw.write(Integer.toString(cover(numberBoard)));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}

