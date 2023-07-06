package baek_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConnectedComponent {

    static int N;
    static int M;
    static int[][] edge;
    static boolean[][] connect;
    static boolean[] isVisited;
    static int result = 0;

    static void dfs(int node) {
        // 노드 방문 체크
        isVisited[node] = true;

        for (int i = 1; i <= N; i++) {
            // 연결이 되어있고, 아직 방문하지 않았다면
            if (connect[node][i] && !isVisited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        edge = new int[M][2];
        connect = new boolean[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        // 만약 간선이 하나도 없다면
        if (M == 0) {
            System.out.println(N);
            return;
        }

        // 노드의 간선 입력
        for (int i = 0; i < M; i++) {
            edge[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            connect[edge[i][0]][edge[i][1]] = true;
            connect[edge[i][1]][edge[i][0]] = true;
        }

        // 노드 탐색 방문한 적 없는 노드라면 처음보는 그룹이라는 뜻!
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }
}
