package pro_set;

import java.util.Arrays;
import java.util.HashSet;

public class ADictionary {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;

        HashSet<String> setSpell = new HashSet<>(Arrays.asList(spell));
        for (String word : dic) {
            HashSet<String> setDic = new HashSet<>(Arrays.asList(word.split("")));
            if (setSpell.equals(setDic)) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}
