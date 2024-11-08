import java.util.*;
import java.io.*;

public class Lis {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int arraySize = Integer.parseInt(br.readLine());
		int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] dp = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

		bw.write(Integer.toString(Arrays.stream(dp).max().getAsInt()));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
