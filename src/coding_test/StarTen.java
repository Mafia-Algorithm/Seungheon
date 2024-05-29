package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarTen {

    static char[][] star;

    static void drawStar(int x, int y, int N, boolean isBlank) {

        if (isBlank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            star[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                drawStar(i, j, size, count == 5);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        star = new char[N][N];

        drawStar(0, 0, N, false);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(star[i][j]);
            }
            s.append("\n");
        }

        System.out.print(s);
    }
}
