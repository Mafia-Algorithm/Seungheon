import java.util.*;
import java.io.*;

public class BinomialCoefficient {

	static final int MOD = 1000000007;	
	static long[] modArray;

	static long fastPow(long base, int exp, int mod) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = ((long) result * base % mod);
            }
            base = ((long) base * base % mod);
            exp >>= 1;
        }

        return result;
    }

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		modArray = new long[N + 1];
		modArray[1] = 1L;
		if (N == 1) {
			bw.write(Long.toString(N));
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		}
		if (K == 0) {
			bw.write("1");
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		}
		modArray[2] = 2L;

		for (int i = 3; i <= N; i++) {
			modArray[i] = (i % MOD * modArray[i - 1]) % MOD;
		}

		long numerator = modArray[N];
		long denominator = (modArray[K] * modArray[N - K]) % MOD;
		long result = (numerator * fastPow(denominator, MOD - 2, MOD)) % MOD;

		bw.write(Long.toString(result));
		bw.newLine();

		bw.flush();
		bw.close();
	}
}
