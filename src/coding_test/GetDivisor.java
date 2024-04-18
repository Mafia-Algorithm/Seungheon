package coding_test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GetDivisior {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> divisor = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) divisor.add(i);
        }

        if (K - 1 >= divisor.size()) {
            bw.write("0");
        } else {
            int answer = divisor.get(K - 1);
            bw.write(Integer.toString(answer));
        }

        bw.flush();
        bw.close();
    }
}
