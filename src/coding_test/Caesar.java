package coding_test;

import java.io.*;

public class Caesar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String secret = br.readLine();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (c - 3 < 'A') {
                bw.write(c - 3 + 26);
            } else {
                bw.write(c - 3);
            }
        }

        bw.flush();
        bw.close();
    }
}
