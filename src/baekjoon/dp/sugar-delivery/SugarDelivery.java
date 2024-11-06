import java.io.*;

public class SugarDelivery {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[0] = -1;
		dp[1] = -1;
		dp[2] = -1;

		if (N == 3) {
			bw.write("1");
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		} else if (N == 4) {
			bw.write("-1");
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		} else if (N == 5) {
			bw.write("1");
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		}

		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;

		for (int i = 6; i < dp.length; i++) {
			if (dp[i - 3] == -1 && dp[i - 5] == -1) {
				dp[i] = -1;
				continue;
			}

			if (dp[i - 3] == -1 && dp[i - 5] != -1) {
				dp[i] = dp[i - 5] + 1;
				continue;
			} else if (dp[i - 3] != -1 && dp[i - 5] == -1) {
				dp[i] = dp[i - 3] + 1;
				continue;
			}

			dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
		}
	
		bw.write(Integer.toString(dp[N]));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
