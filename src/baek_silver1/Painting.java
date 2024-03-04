package baek_silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Painting {

    static int n, m;
    static int[][] paper;
    static boolean[][] check;
    static int count = 0;
    static int maxSize = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int dfs(int x, int y) {

        int size = 1;
        check[x][y] = true;

        for (int i = 0 ; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && !check[nextX][nextY] && paper[nextX][nextY] == 1) {
                size += dfs(nextX, nextY);
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = inputs[0];
        m = inputs[1];

        paper = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            int[] paint = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            paper[i] = paint;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !check[i][j]) {
                    count++;
                    int size = dfs(i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }
}
