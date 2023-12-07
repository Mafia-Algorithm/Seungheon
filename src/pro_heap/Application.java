package pro_heap;

public class Application {
    public static void main(String[] args) {
        MoreSpicy moreSpicy = new MoreSpicy();
        System.out.println(moreSpicy.solution(
                new int[]{1, 2, 3, 9, 10, 12},
                7
        ));
    }
}
