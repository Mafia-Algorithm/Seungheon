package pro_realization;

public class Application {
    public static void main(String[] args) {
        PushKeypad pushKeypad = new PushKeypad();
        System.out.println(pushKeypad.solution(
                new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                "left"
        ));
    }
}
