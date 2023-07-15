package baek_20529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MBTI {

    static int T;
    static int N;
    static String[] mbtiList;
    static int[] mbtiCount;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            mbtiList = br.readLine().split(" ");

            if(N > 32) {
                System.out.println(0);
                continue;
            }

            for (int k = 0; k < N - 2; k++) {
                for (int l = k + 1; l < N - 1; l++) {
                    for (int m = l + 1; m < N; m++) {
                        String[] temp = {mbtiList[k], mbtiList[l], mbtiList[m]};
                        mbtiCount = new int[8];

                        for (String mbti : temp) {
                            for (int n = 0; n < 4; n++) {
                                char alphabet = mbti.charAt(n);

                                if (alphabet == 'E') {
                                    mbtiCount[0]++;
                                }

                                if (alphabet == 'I') {
                                    mbtiCount[1]++;
                                }

                                if (alphabet == 'N') {
                                    mbtiCount[2]++;
                                }

                                if (alphabet == 'S') {
                                    mbtiCount[3]++;
                                }

                                if (alphabet == 'T') {
                                    mbtiCount[4]++;
                                }

                                if (alphabet == 'F') {
                                    mbtiCount[5]++;
                                }

                                if (alphabet == 'J') {
                                    mbtiCount[6]++;
                                }

                                if (alphabet == 'P') {
                                    mbtiCount[7]++;
                                }
                            }
                        }

                        int distance = mbtiCount[0] * mbtiCount[1] + mbtiCount[2] * mbtiCount[3] + mbtiCount[4] * mbtiCount[5] + mbtiCount[6] * mbtiCount[7];
                        if (distance < result) {
                            result = distance;
                        }
                    }
                }
            }

            System.out.println(result);
            result = Integer.MAX_VALUE;
        }
    }
}
