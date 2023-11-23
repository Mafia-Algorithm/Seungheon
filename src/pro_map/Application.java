package pro_map;

public class Application {
    public static void main(String[] args) {
        PersonalityType personalityType = new PersonalityType();
        System.out.println(personalityType.solution(
                new String[]{"AN", "CF", "MJ", "RT", "NA"},
                new int[]{5, 3, 2, 7, 5}
        ));
    }
}
