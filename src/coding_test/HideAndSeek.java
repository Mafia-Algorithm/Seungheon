package coding_test;

import java.io.*;
import java.util.*;

public class HideAndSeek {
    
    static int answer = Integer.MAX_VALUE;
    static int N;
    static int K;
    static boolean[] visited;

    static class Node {
        int position;
        int second;

        public Node(int position, int second) {
            this.position = position;
            this.second = second;
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.position] = true;
            if (node.position == K) {
                answer = Math.min(answer, node.second);
            }

            if (node.position * 2 <= 100000 && !visited[node.position * 2]) {
                queue.add(new Node(node.position * 2, node.second));
            }

            if (node.position + 1 <= 100000 && !visited[node.position + 1]) {
                queue.add(new Node(node.position + 1, node.second + 1));
            }

            if(node.position - 1 >= 0 && !visited[node.position - 1]) {
                queue.add(new Node(node.position - 1, node.second + 1));
            } 
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        bfs();

        bw.write(Integer.toString(answer) + "\n");
        bw.flush();
        bw.close();
    }
}
