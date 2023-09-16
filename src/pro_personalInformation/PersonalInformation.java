package pro_personalInformation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PersonalInformation {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate date = LocalDate.parse(today, formatter);
        ArrayList<Integer> array = new ArrayList<>();

        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            map.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyInformation = privacies[i].split(" ");
            String key = privacyInformation[1];

            int limitMonth = map.get(key);
            LocalDate limitDate = LocalDate.parse(privacyInformation[0], formatter);
            if (limitDate.plusMonths(limitMonth).isEqual(date) || limitDate.plusMonths(limitMonth).isBefore(date)) {
                array.add(i + 1);
            }
        }

        int[] answer = new int[array.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = array.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}
        )));
    }
}
