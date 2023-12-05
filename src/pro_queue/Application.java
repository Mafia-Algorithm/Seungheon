package pro_queue;

public class Application {
    public static void main(String[] args) {
        Process process = new Process();
        System.out.println(process.solution(
                new int[]{2, 1, 9, 1, 9, 1},
                1
        ));
    }
}
