import java.util.*;
import java.io.*;

public class SayMiddle {

	static List<Integer> numberList = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			int index = Collections.binarySearch(numberList, input);
			if (index < 0) {
				index = -(index + 1);
			}

			numberList.add(index, input);
			if (numberList.size() % 2 == 0) {
				bw.write(Integer.toString(numberList.get(numberList.size() / 2 - 1)));
			} else {
				bw.write(Integer.toString(numberList.get(numberList.size() / 2)));
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
