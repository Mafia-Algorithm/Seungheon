import java.util.*;
import java.io.*;

public class Multiple {

	private static int C;

	private static long recursion(int base, int exponents) {
		if (exponents == 1) {
			return base % C;
		}

		long temp = recursion(base, exponents / 2);
		if (exponents % 2 == 1) {
			return (temp * temp % C) * base % C;
		}

		return temp * temp % C;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int A = input[0];
		int B = input[1];
		C = input[2];

		long answer = recursion(A, B);
		bw.write(Long.toString(answer));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
