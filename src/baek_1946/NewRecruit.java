package baek_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NewRecruit {

    static int T;
    static int N;
    static int[][] ranking;
    static boolean[] isPass;
    static int result = 0;

    static void passCheck(int[][] ranking) {

        // 서류 1등의 면접 점수가 처음 기준
        int interviewPassRank = ranking[0][1];

        // 서류 1등은 합격
        isPass[0] = true;

        for (int i = 1; i <= ranking.length - 1; i++) {
            // 면접 등수가 현재 기준보다 더 높다면
            if (ranking[i][1] < interviewPassRank) {
                isPass[i] = true;
                interviewPassRank = ranking[i][1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            isPass = new boolean[N];

            ranking = new int[N][2];
            for (int applicant = 0; applicant < N; applicant++) {
                ranking[applicant] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 서류 성적 기준으로 내림차순 정리
            Arrays.sort(ranking, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            passCheck(ranking);

            for (boolean pass : isPass) {
                if (pass) {
                    result++;
                }
            }

            System.out.println(result);
            result = 0;
        }
    }
}
