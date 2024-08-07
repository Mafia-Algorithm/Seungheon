import java.util.*;
import java.io.*;

public class Cabbage {
    
    private static boolean[][] cabbageFarm;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int N;
    private static int M;
    private static int K;

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (0 <= nextX && nextX <N && 0 <= nextY && nextY < M && !visited[nextX][nextY] && cabbageFarm[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int answer = 0;
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = input[0];
            M = input[1];
            K = input[2];

            cabbageFarm = new boolean[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = position[0];
                int y = position[1];

                cabbageFarm[x][y] = true;
            }

            for (int k = 0; k < N; k++) {
                for (int l = 0; l < M; l++) {
                    if (cabbageFarm[k][l] && !visited[k][l]) {
                        dfs(k, l);
                        answer++;
                    }
                }
            }
            
            bw.write(Integer.toString(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
