package coding_test;

import java.io.*;

public class Signal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int size = s.length() / 5;
        char[][] signal = new char[5][size];
        for (int i = 0; i < signal.length; i++) {
            for (int j = i * size; j < i * size + size; j++) {
                signal[i][j - i * size] = s.charAt(j);
            }
        }

        for (int i = 0; i < signal.length; i++) {
            for (int j = 0; j < signal[i].length; j++) {
                System.out.print(signal[i][j] + " ");
            }

            System.out.println();
        }
    }
}
