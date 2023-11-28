package pro_set;

import java.util.HashSet;

public class DuplicationDelete {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < my_string.length(); i++) {
            String c = Character.toString(my_string.charAt(i));
            if (set.contains(c)) {
                continue;
            } else {
                sb.append(c);
                set.add(c);
            }
        }

        return sb.toString();
    }
}
