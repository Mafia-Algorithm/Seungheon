import java.util.*;
import java.io.*;

public class Pipelined {

	static int[] pipeline;
	static int completeCount = 0;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		pipeline = new int[N];
		int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int max = inputs[0];
		for (int i = 1; i < inputs.length; i++) {
			if (max < inputs[i]) {
				max = inputs[i];
			}
		}

		answer = max + N - 1;

		bw.write(Integer.toString(answer));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
