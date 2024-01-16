package baek_silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SafeZone {

    static int N;
    static int[][] height;
    static boolean[][] isCheck;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    static int safeArea = Integer.MIN_VALUE;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    private static void dfs(int sinkHeight, int x, int y) {
        isCheck[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !isCheck[nextX][nextY] && sinkHeight < height[nextX][nextY]) {
                dfs(sinkHeight, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        height = new int[N][N];
        for (int i = 0; i < N; i++) {
            height[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int h : height[i]) {
                MIN = Math.min(MIN, h);
                MAX = Math.max(MAX, h);
            }
        }

        for (int i = MIN; i <= MAX; i++) {

            if (MIN == MAX) {
                safeArea = 1;
                break;
            }

            isCheck = new boolean[N][N];
            int safeAreaCount = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // 아직 방문한 적이 없고 이번 확인하는 강수량보다 지역이 높을 때
                    if (!isCheck[j][k] && height[j][k] > i) {
                        dfs(i, j, k);
                        safeAreaCount++;
                    }
                }
            }

            safeArea = Math.max(safeArea, safeAreaCount);
        }

        System.out.println(safeArea);
    }
}
