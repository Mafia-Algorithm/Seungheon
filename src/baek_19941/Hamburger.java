package baek_19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hamburger {

    static int N;
    static int K;
    static String[] table;
    static boolean[] isEat;
    static int eatPerson = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        K = input[1];

        table = br.readLine().split("");
        isEat = new boolean[N];

        // 테이블 순회
        for (int i = 0; i < N; i++) {
            // 사람이면
            if (table[i].equals("P")) {

            }
        }
    }
}
