import java.io.*;

public class Boggle {

	private static String[][] board = new String[5][5];
	private static String[] words;
	private static int[] canGetWord;

	private static int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
	private static int[] dy = {1, -1, 0, -1, 1, 0, -1, 1};

	private static void checkGetWordInBoard (int x, int y, String current, int target) {
		if (current.equals(words[target])) {
			canGetWord[target] = 1;
		}

		String targetWord = words[target];

		if (current.length() >= targetWord.length()) {
			return;
		}

		for (int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (0 <= nextX && nextX < 5 && 0 <= nextY && nextY < 5 && board[nextX][nextY].equals(String.valueOf(targetWord.charAt(current.length())))) {
				checkGetWordInBoard(nextX, nextY, current + board[nextX][nextY], target);
			}
		}
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
				char firstAlphabet = word.charAt(0);
				System.out.println(word + " " + firstAlphabet);
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (String.valueOf(firstAlphabet).equals(board[j][k])) {
							checkGetWordInBoard(j, k, board[j][k], i);		
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
