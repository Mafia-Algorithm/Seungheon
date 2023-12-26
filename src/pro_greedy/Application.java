package pro_greedy;

public class Application {
    public static void main(String[] args) {
        Camera camera = new Camera();
        System.out.println(camera.solution(
                new int[][] {
                        {-20,-15},
                        {-14,-5},
                        {-18,-13},
                        {-5,-3}
                }
        ));
    }
}
