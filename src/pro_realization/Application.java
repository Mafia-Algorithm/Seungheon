package pro_realization;

public class Application {
    public static void main(String[] args) {
       SafetyZone safetyZone = new SafetyZone();
        System.out.println(safetyZone.solution(
                new int[][] {
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                }
        ));
    }
}
