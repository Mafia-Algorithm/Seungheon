package pro_stack;

public class Application {
    public static void main(String[] args) {
        MakeHamburger makeHamburger = new MakeHamburger();
        System.out.println(makeHamburger.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }
}
