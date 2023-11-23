package pro_map;

public class Application {
    public static void main(String[] args) {
        LoginSuccess loginSuccess = new LoginSuccess();
        System.out.println(loginSuccess.solution(
                new String[]{"programmer01", "15789"},
                new String[][]{
                        {"programmer02", "111111"},
                        {"programmer00", "134"},
                        {"programmer01", "1145"}
                }
        ));
    }
}
