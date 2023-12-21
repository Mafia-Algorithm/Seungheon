package pro_bfs;

public class Application {
    public static void main(String[] args) {
        InGameShortest inGameShortest = new InGameShortest();
        System.out.println(inGameShortest.solution(
                new int[][]{
                        {1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}
                }
        ));
    }
}
