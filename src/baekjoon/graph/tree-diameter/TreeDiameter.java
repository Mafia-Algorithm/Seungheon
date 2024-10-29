import java.util.*;
import java.io.*;

public class TreeDiameter {

	private static List<List<List<Integer>>> connection;
	private static boolean[] isVisited;
	private static int maxLength = Integer.MIN_VALUE;
	private static int farthestNode;

	static void dfs(int currentNode, int length) {

		// 방문 처리
		isVisited[currentNode] = true;

		// 거리 비교
		if (maxLength < length) {
			maxLength = length;
			farthestNode = currentNode;
		}

		// 다음 노드 방문
		List<List<Integer>> con = connection.get(currentNode);
		for (List<Integer> nextNode : con) {
			int nextNodeValue = nextNode.get(0);
			int nextLength = nextNode.get(1);
			if (!isVisited[nextNodeValue]) {
				dfs(nextNodeValue, length + nextLength);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		connection = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			connection.add(new ArrayList<>());
		}

		for (int i = 1; i < n; i++) {
			int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int parentValue = inputs[0];
			int childValue = inputs[1];
			int length = inputs[2];

			connection.get(parentValue).add(List.of(childValue, length));
			connection.get(childValue).add(List.of(parentValue, length));
		}

		// 첫 번째 DFS 실행
		isVisited = new boolean[n + 1];
		dfs(1, 0);

		// 두 번째 DFS 실행 (farthestNode에서 시작)
		isVisited = new boolean[n + 1];
		maxLength = Integer.MIN_VALUE;
		dfs(farthestNode, 0);

		bw.write(Integer.toString(maxLength));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
