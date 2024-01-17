package baek_silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StartLink {

    static int N;
    static int[][] statusBoard;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] isIn;

    static void combination(int idx, int count) {
        if (count == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!isIn[i]) {
                isIn[i] = true;
                combination(i + 1, count + 1);
                isIn[i] = false;
            }
        }
    }

    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isIn[i] && isIn[j]) {
                    team_start += statusBoard[i][j];
                    team_start += statusBoard[j][i];
                }
                else if (!isIn[i] && !isIn[j]) {
                    team_link += statusBoard[i][j];
                    team_link += statusBoard[j][i];
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        MIN = Math.min(val, MIN);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        statusBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            statusBoard[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        isIn = new boolean[N];

        combination(0, 0);
        System.out.println(MIN);
    }
}
