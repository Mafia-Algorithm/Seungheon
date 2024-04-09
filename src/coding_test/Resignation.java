package coding_test;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class Resignation {

    static int N;
    static int[][] table;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        table = new int[N + 2][2];
        dp = new int[N + 2];
        for (int i = 1; i < N + 1; i++) {
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int max = -1;
        for (int i = 1; i <= N + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int next = i + table[i][0];
            if (next < N + 2) {
                dp[next] = Math.max(dp[next], max + table[i][1]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}
