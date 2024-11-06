import java.util.*;
import java.io.*;

public class RGBStreet {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			dp[i][0] = input[0];
			dp[i][1] = input[1];
			dp[i][2] = input[2];
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		bw.write(Integer.toString(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2])));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
