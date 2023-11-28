package pro_set;

public class Application {
    public static void main(String[] args) {
        ADictionary dictionary = new ADictionary();
        System.out.println(dictionary.solution(
                new String[]{"z", "d", "x"},
                new String[]{"def", "dww", "dzx", "loveaw"}
        ));
    }
}
