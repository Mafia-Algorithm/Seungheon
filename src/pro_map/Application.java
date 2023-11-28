package pro_map;

public class Application {
    public static void main(String[] args) {
        Dress dress = new Dress();
        System.out.println(dress.solution(
                new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}
        ));
    }
}
