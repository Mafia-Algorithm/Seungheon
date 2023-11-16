package pro_realization;

public class Application {
    public static void main(String[] args) {
        CardDummy cardDummy = new CardDummy();
        System.out.println(cardDummy.solution(
                new String[]{"i", "drink", "water"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        ));
    }
}
