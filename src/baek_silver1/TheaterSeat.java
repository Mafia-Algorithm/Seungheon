package baek_silver1;

import java.io.*;

public class TheaterSeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int answer = 1;

        int beforeSeat = 0;
        for (int i = 0; i < M; i++) {
            int vipSeat = Integer.parseInt(br.readLine());
            answer *= dp[vipSeat - beforeSeat - 1];
            beforeSeat = vipSeat;
        }
        answer *= dp[N - beforeSeat];

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
