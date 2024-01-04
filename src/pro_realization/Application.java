package pro_realization;

public class Application {
    public static void main(String[] args) {
       PaintOver paintOver = new PaintOver();
       System.out.println(paintOver.solution(
               8,
               4,
               new int[]{2, 3, 6}
       ));
    }
}
