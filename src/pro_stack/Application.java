package pro_stack;

public class Application {
    public static void main(String[] args) {
        CorrectBracket correctBracket = new CorrectBracket();
        System.out.println(correctBracket.solution(")()("));
    }
}
