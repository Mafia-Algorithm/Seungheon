import java.io.*;
import java.util.*;

public class DFSAndBFS {

    private static int N;
    private static int M;
    private static int V;
    private static boolean[][] link;
    private static boolean[] visited;

    private static void dfs(int start) {
        // 노드 방문 체크
        visited[start] = true;

        // 방문 후 출력
        System.out.print(start + " ");

        // 연결된 노드 확인 및 방문 확인
        for (int i = 1; i <= N; i++) {
            if (link[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        // BFS용 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // 모두 방문할 때 까지 순회
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                System.out.print(node + " ");
            }
            visited[node] = true;
            for (int i = 1; i <= N; i++) {
                if (link[node][i] && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        V = input[2];
        
        link = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int[] connectedPoint = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            link[connectedPoint[0]][connectedPoint[1]] = true;
            link[connectedPoint[1]][connectedPoint[0]] = true;
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }
}
