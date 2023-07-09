package baek_20529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MBTI {

    static int T;
    static int N;
    static String[] mbtiList = new String[]{"ISFP", "ISFJ", "ISTP", "ISTJ", "INFP", "INFJ", "INTP", "INTJ", "ESFP", "ESFJ", "ESTP", "ESTJ", "ENFP", "ENFJ", "ENTP", "ENTJ"};
    static String[] mbtiInput;
    static String[] temp;

    static void recursion(int index, int depth) {
        if (index == 3) {
            return;
        }

        temp[depth] = mbtiInput[index];
        recursion(index + 1, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            mbtiInput = br.readLine().split(" ");

            for (int j = 0; j <= N -3; j++) {
                recursion(j, 0);

            }
        }
    }
}
