package pro_realization;

public class Application {
    public static void main(String[] args) {
       Parallel parallel = new Parallel();
        System.out.println(parallel.solution(
                new int[][] {
                        {1, 2},
                        {2, 1},
                        {3, 4},
                        {4, 5}
                }
        ));
    }
}
