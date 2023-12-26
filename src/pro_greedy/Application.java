package pro_greedy;

public class Application {
    public static void main(String[] args) {
        WorkoutClothes workoutClothes = new WorkoutClothes();
        System.out.println(workoutClothes.solution(
                5,
                new int[]{2, 4},
                new int[]{3}
        ));
    }
}
