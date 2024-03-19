package baek_silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[51][1001];
        int answer = -1;
        int[] volumeList = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volumeList[i] = Integer.parseInt(st.nextToken());
        }

        if (S - volumeList[0] >= 0) dp[0][S - volumeList[0]] = true;
        if (S + volumeList[0] <= M) dp[0][S + volumeList[0]] = true;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= M; j++) {
                if (!dp[i][j]) continue;

                if (j - volumeList[i + 1] >= 0) {
                    dp[i + 1][j - volumeList[i + 1]] = true;
                }
                if (j + volumeList[i + 1] <= M) {
                    dp[i + 1][j + volumeList[i + 1]] = true;
                }
            }
        }
        for (int i = 0; i <= M; i++) {
            if (dp[N - 1][i] && i > answer) answer = i;
        }
        System.out.println(answer);
    }
}
