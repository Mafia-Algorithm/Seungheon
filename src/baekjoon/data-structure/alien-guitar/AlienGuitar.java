import java.util.*;
import java.io.*;

public class AlienGuitar {

	private static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = input[0];
		int P = input[1];

		HashMap<Integer, Stack<Integer>> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int[] nAndP = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int lineNumber = nAndP[0];
			int fretNumber = nAndP[1];

			// 처음 줄을 사용하는 경우
			if (!map.containsKey(lineNumber)) {
				Stack<Integer> stack = new Stack<>();
				stack.push(fretNumber);
				answer++;
				map.put(lineNumber, stack);
			} else {
				Stack<Integer> stack = map.get(lineNumber);
				// 아직 누르고 있는 프렛이 없는 경우
				if (stack.isEmpty()) {
					stack.push(fretNumber);
					answer++;
				} else {
					int highFret = stack.peek();
					if (highFret > fretNumber) {
						// 입력하려는 프렛보다 작거나 같은 수가 나올 때까지 손 떼기
						while(!stack.isEmpty() && stack.peek() > fretNumber) {
							stack.pop();
							answer++;
						}

						if (!stack.isEmpty() && stack.peek() == fretNumber) {
							continue;
						}
						stack.push(fretNumber);
						answer++;
					} else if (highFret == fretNumber) { // 입력하려는 프렛이 눌려있는 경우
						continue;
					} else { // 입력하려는 프렛이 현재 누르고 있는 프렛보다 큰 경우
						stack.push(fretNumber);
						answer++;
					}
				}
			}
		}

		bw.write(Integer.toString(answer));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
