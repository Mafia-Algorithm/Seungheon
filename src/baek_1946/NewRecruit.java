package baek_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NewRecruit {

    static int T;
    static int N;
    static int[][] score;
    static boolean[] isPass;
    static int result = 0;

    static void passCheck(int[][] nowScore) {
        for (int i = 1; i < nowScore.length - 1; i++) {

            // 이미 탈락 처리가 된 응시자는 확인하지 않음
            if (!isPass[i]) {
                continue;
            }

            for (int j = i + 1; j < nowScore.length; j++) {
                System.out.println(nowScore[i][0] + " / " + nowScore[i][1]);
                System.out.println(nowScore[j][0] + " / " + nowScore[j][1]);

                // 본인이 다른 지원자에 비해 두 분야 모두 뛰어나다면
                if (nowScore[i][0] > nowScore[j][0] && nowScore[i][1] > nowScore[j][1]) {
                    System.out.println(i);
                    System.out.println(j);
                    isPass[j] = false;
                }

                // 본인이 다른 지원자에 비해 두 분야 모두 떨어진다면
                if (nowScore[i][0] < nowScore[j][0] && nowScore[i][1] < nowScore[j][1]) {
                    System.out.println(i);
                    System.out.println(j);
                    isPass[i] = false;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            isPass = new boolean[N + 1];
            Arrays.fill(isPass, true);

            score = new int[N + 1][2];
            for (int applicant = 1; applicant <= N; applicant++) {
                score[applicant] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            passCheck(score);

            for (boolean pass : isPass) {
                if (pass) {
                    result++;
                }
            }

            System.out.println(Arrays.toString(isPass));
            System.out.println(result - 1);
            result = 0;
        }
    }
}
