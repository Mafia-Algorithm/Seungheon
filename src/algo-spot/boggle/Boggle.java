import java.io.*;

public class Boggle {

	private static String[][] board = new String[5][5];
	private static String[] words;
	private static int[] canGetWord;

	private static int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
	private static int[] dy = {1, -1, 0, -1, 1, 0, -1, 1};

	private static boolean inRange(int x, int y) {

		if (0 <= x && x < 5 && 0 <= y && y < 5) return true;
		else return false;
	}

	private static boolean hasWord(int x, int y, String target) {

		// 범위를 벗어난 경우
		if (!inRange(x, y)) return false;

		// 첫 글자가 일치하지 않는 경우
		if (!board[x][y].equals(String.valueOf(target.charAt(0)))) return false;

		// 단어 길이가 1이면 성공
		if (target.length() == 1) return true;

		// 인접한 8칸을 검사
		for (int direction = 0; direction < 8; direction++) {
			int nextX = x + dx[direction];
			int nextY = y + dy[direction];

			if (hasWord(nextX, nextY, target.substring(1))) return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for (int test = 0; test < testCase; test++) {
			for (int i = 0; i < board.length; i++) {
				board[i] = br.readLine().split("");
			}

			int wordCount = Integer.parseInt(br.readLine());
			words = new String[wordCount];
			canGetWord = new int[wordCount];
			for (int i = 0; i < wordCount; i++) {
				words[i] = br.readLine();	
			}

			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (hasWord(j, k, word)) {
							canGetWord[i] = 1;
						}
					}
				}

				if (canGetWord[i] == 0) {
					canGetWord[i] = -1;
				}
			}

			for (int i = 0; i < wordCount; i++) {
				if (canGetWord[i] == -1) {
					bw.write(words[i] + " " + "NO");
					bw.newLine();
				} else if (canGetWord[i] == 1) {
					bw.write(words[i] + " " + "YES");
					bw.newLine();
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
