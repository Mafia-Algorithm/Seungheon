import java.util.*;
import java.io.*;

public class SwanLake {
    static String[][] lake;
    static boolean[][] waterVisited, swanVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int R, C;
    static int[] swan1, swan2;
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> swanQueue = new LinkedList<>();
    static Queue<int[]> nextSwanQueue = new LinkedList<>();

    static boolean bfs() {
        while (!swanQueue.isEmpty()) {
            int[] pos = swanQueue.poll();
            int x = pos[0], y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || swanVisited[nx][ny]) continue;

                if (nx == swan2[0] && ny == swan2[1]) return true;  // 두 번째 백조를 만나면 종료

                swanVisited[nx][ny] = true;
                if (lake[nx][ny].equals("X")) {
                    nextSwanQueue.add(new int[]{nx, ny});  // 다음 날 탐색해야 할 얼음
                } else {
                    swanQueue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    static void meltIce() {
        int size = waterQueue.size();
        for (int i = 0; i < size; i++) {
            int[] pos = waterQueue.poll();
            int x = pos[0], y = pos[1];

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || waterVisited[nx][ny]) continue;

                if (lake[nx][ny].equals("X")) {
                    lake[nx][ny] = ".";  // 얼음이 녹아 물이 됨
                    waterQueue.add(new int[]{nx, ny});
                }
                waterVisited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lake = new String[R][C];
        waterVisited = new boolean[R][C];
        swanVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            lake[i] = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (lake[i][j].equals("L")) {
                    if (swan1 == null) {
                        swan1 = new int[]{i, j};
                    } else {
                        swan2 = new int[]{i, j};
                    }
                    lake[i][j] = ".";
                    waterQueue.add(new int[]{i, j});
                } else if (lake[i][j].equals(".")) {
                    waterQueue.add(new int[]{i, j});
                    waterVisited[i][j] = true;
                }
            }
        }

        // 첫 번째 백조 위치에서 BFS 시작
        swanQueue.add(swan1);
        swanVisited[swan1[0]][swan1[1]] = true;

        int days = 0;
        while (true) {
            // 백조들이 서로 만날 수 있는지 확인
            if (bfs()) {
                System.out.println(days);
                return;
            }

            // 다음 날 이동할 백조의 경로를 업데이트
            swanQueue = nextSwanQueue;
            nextSwanQueue = new LinkedList<>();

            // 얼음을 녹임
            meltIce();

            // 날을 증가시킴
            days++;
        }
    }
}
