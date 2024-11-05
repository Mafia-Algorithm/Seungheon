import java.io.*;

public class TreeCircuit {

	static StringBuilder sb = new StringBuilder();

	static class Node {

		private String value;
		private Node leftNode;
		private Node rightNode;

		public Node(String value, Node leftNode, Node rightNode) {
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}

		public String getValue() {
			return this.value;
		}

		public Node getLeftNode() {
			return this.leftNode;
		}

		public Node getRightNode() {
			return this.rightNode;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
	}

	private static void frontFind(Node startNode) {
		if (startNode == null) {
			return;
		}

		sb.append(startNode.getValue());
		frontFind(startNode.getLeftNode());
		frontFind(startNode.getRightNode());
	}

	private static void middleFind(Node startNode) {
		if (startNode == null) {
			return;
		}

		middleFind(startNode.getLeftNode());
		sb.append(startNode.getValue());
		middleFind(startNode.getRightNode());
	}

	private static void backFind(Node startNode) {
		if (startNode == null) {
			return;
		}

		backFind(startNode.getLeftNode());
		backFind(startNode.getRightNode());
		sb.append(startNode.getValue());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Node[] nodeList = new Node[26];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			String rootNodeValue = input[0];
			String leftNodeValue = input[1];
			String rightNodeValue = input[2];

			char rootIndex = rootNodeValue.charAt(0);
			int rootNumIndex = rootIndex - 'A';
			if (!rootNodeValue.equals(".") && nodeList[rootNumIndex] == null) {
				nodeList[rootNumIndex] = new Node(rootNodeValue, null, null);
			}

			char leftIndex = leftNodeValue.charAt(0);
			int leftNumIndex = leftIndex - 'A';
			if (!leftNodeValue.equals(".") && nodeList[leftNumIndex] == null) {
				nodeList[leftNumIndex] = new Node(leftNodeValue, null, null);
			}

			char rightIndex = rightNodeValue.charAt(0);
			int rightNumIndex = rightIndex - 'A';
			if (!rightNodeValue.equals(".") && nodeList[rightNumIndex] == null) {
				nodeList[rightNumIndex] = new Node(rightNodeValue, null, null);
			}

			if (0 <= leftNumIndex && leftNumIndex < 26) {
				nodeList[rootNumIndex].setLeftNode(nodeList[leftNumIndex]);
			}


			if (0 <= rightNumIndex && rightNumIndex < 26) {
				nodeList[rootNumIndex].setRightNode(nodeList[rightNumIndex]);
			}
		}

		frontFind(nodeList[0]);
		sb.append("\n");
		middleFind(nodeList[0]);
		sb.append("\n");
		backFind(nodeList[0]);
		sb.append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
