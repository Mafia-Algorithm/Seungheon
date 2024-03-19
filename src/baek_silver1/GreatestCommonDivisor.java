package baek_silver1;

import java.io.*;
import java.util.StringTokenizer;

public class GreatestCommonDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n1 = Long.parseLong(st.nextToken());
        long n2 = Long.parseLong(st.nextToken());

        long repeat = gcd(n1, n2);

        String gcd = "1".repeat((int) repeat);

        bw.write(gcd + "\n");
        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b) {

        if (b == 0) return a;
        else {
            long r = a % b;
            return gcd(b, r);
        }

    }
}
