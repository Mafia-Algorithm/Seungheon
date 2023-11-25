package pro_map;

import java.util.HashMap;

public class LoginSuccess {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";

        HashMap<String, String> database = new HashMap<>();
        for (String[] strings : db) {
            database.put(strings[0], strings[1]);
        }

        if (database.containsKey(id_pw[0])) {
            if (database.get(id_pw[0]).equals(id_pw[1])) answer = "login";
            else answer = "wrong pw";
        } else {
            answer = "fail";
        }

        return answer;
    }
}
