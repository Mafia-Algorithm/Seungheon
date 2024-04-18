package coding_test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(br.readLine());
            int now = number;
            for (int j = number; j >= 0; j--) {
                if (now >= Math.pow(2, j)) {
                    answer.add(j);
                    now -= (int) Math.pow(2, j);
                }
            }

            Collections.reverse(answer);
            for (int n : answer) {
                bw.write(Integer.toString(n) + " ");
            }
            bw.newLine();
            answer = new ArrayList<>();
        }

        bw.flush();
        bw.close();
    }
}
