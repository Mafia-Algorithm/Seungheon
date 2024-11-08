import java.util.*;
import java.io.*;

public class MakeOne {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			
			if (i % 3 == 0 && i % 2 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i / 2] + 1, dp[i - 1] + 1));
				continue;
			}

			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
				continue;
			}

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
				continue;
			}

			dp[i] = dp[i - 1] + 1;
		}

		bw.write(Integer.toString(dp[N]));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
