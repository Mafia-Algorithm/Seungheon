package pro_dfs;

public class Application {
    public static void main(String[] args) {
        Network network = new Network();
        System.out.println(network.solution(
                3,
                new int[][]{
                        {1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1}
                }
        ));
    }
}
