import java.util.*;
import java.io.*;

public class TreeParent {

	static int N;
	static boolean[] isVisited;
	static List<List<Integer>> connection = new ArrayList<>();
	static Node[] nodeList;

	static class Node {

		Node parent;
		int value;

		public Node(int value) {
			this.value = value;
		}

		public Node getParent() {
			return this.parent;
		}

		public int getValue() {
			return this.value;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}
	}

	static void bfs(Node currentNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        isVisited[currentNode.getValue()] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentValue = current.getValue();
            for (int neighbor : connection.get(currentValue)) {
                if (!isVisited[neighbor]) {
                    nodeList[neighbor].setParent(current);
                    isVisited[neighbor] = true;
                    queue.add(nodeList[neighbor]);
                }
            }
        }
    }

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		isVisited = new boolean[N + 1];
		nodeList = new Node[N + 1];
		connection.add(new ArrayList<>());

		for (int i = 1; i <= N; i++) {
			nodeList[i] = new Node(i);
			connection.add(new ArrayList<>());
		}

		for (int i = 1; i < N; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int a = input[0];
			int b = input[1];
			connection.get(a).add(b);
			connection.get(b).add(a);
		}

		bfs(nodeList[1]);

		for (int i = 2; i <= N; i++) {
			bw.write(Integer.toString(nodeList[i].getParent().getValue()));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
