package baek_silver1;

import java.io.*;
import java.util.StringTokenizer;

public class TrashFood {

    static int N, M, K;
    static int count = 0;
    static int answer = 0;
    static boolean[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y) {

        isVisited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (1 <= nextX && nextX <= N && 1 <= nextY && nextY <= M && !isVisited[nextX][nextY] && map[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] && !isVisited[i][j]) {
                    dfs(i, j);
                }

                answer = Math.max(answer, count);
                count = 0;
            }
        }

        System.out.println(answer);
    }
}