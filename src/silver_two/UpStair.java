import java.io.*;

public class UpStair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단의 개수
        int stairs = Integer.parseInt(br.readLine());

        // DP
        int[] DP = new int[301];

        // 계단 점수
        int[] stairPoints = new int[301];

        for (int i = 1; i <= stairs; i++) {
            stairPoints[i] = Integer.parseInt(br.readLine());
        }

        // 기본값 저장
        DP[1] = stairPoints[1];
        DP[2] = stairPoints[1] + stairPoints[2];
        DP[3] = Math.max(stairPoints[1], stairPoints[2]) + stairPoints[3];

        for (int i = 4; i <= stairs; i++) {
            DP[i] = Math.max((DP[i-3] + stairPoints[i-1]), DP[i-2]) + stairPoints[i];
        }

        System.out.println(DP[stairs]);
    }
}
