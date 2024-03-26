package baek_silver1;

import java.io.*;
import java.util.StringTokenizer;

public class Sheep {

    static int R, C;
    static String[][] farm;
    static int sheep = 0;
    static int wolf = 0;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int finalSheep = 0;
    static int finalWolf = 0;

    static void dfs(int x, int y) {
        if (farm[x][y].equals("o")) sheep++;
        if (farm[x][y].equals("v")) wolf++;

        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C && !isVisited[nextX][nextY] && !farm[nextX][nextY].equals("#")) {
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        farm = new String[R][C];
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            farm[i] = br.readLine().split("");
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!farm[i][j].equals("#") && !isVisited[i][j]) {
                    dfs(i, j);
                    if (sheep > wolf) {
                        finalSheep += sheep;
                    } else {
                        finalWolf += wolf;
                    }
                    sheep = 0;
                    wolf = 0;
                }
            }
        }

        bw.write(finalSheep + " " + finalWolf + "\n");
        bw.flush();
        bw.close();
    }
}
