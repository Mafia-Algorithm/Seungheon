package pro_dfs;

public class Network {

    boolean[] isVisited;
    int[][] networks;
    int N;

    void dfs(int computer) {
        isVisited[computer] = true;

        for (int i = 0; i < N; i++) {
            if (!isVisited[i] && networks[computer][i] == 1) {
                dfs(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        networks = computers;
        N = n;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }
}
