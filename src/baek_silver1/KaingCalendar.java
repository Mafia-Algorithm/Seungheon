package baek_silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KaingCalendar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1; // 1을 빼서 0 기반으로 만듦
            int y = Integer.parseInt(st.nextToken()) - 1; // 1을 빼서 0 기반으로 만듦

            boolean flag = false;
            for (int k = x; k < (M * N); k += M) { // x를 고정하고 M의 배수만큼 증가
                if (k % N == y) { // N으로 나눈 나머지가 y와 같은지 확인
                    System.out.println(k + 1); // 0 기반으로 계산했으므로 1을 더함
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println(-1); // 조건을 만족하는 해가 없는 경우
            }
        }
    }
}
