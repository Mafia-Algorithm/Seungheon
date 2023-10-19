package pro_dart;

import java.util.ArrayList;

public class Dart {

    public static int solution(String dartResult) {
        int answer = 0;
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) {
                if (array.size() == 2) {
                    array.add(dartResult.substring(i));
                    break;
                }
                if (dartResult.charAt(i + 1) == '0') {
                    String four = dartResult.substring(i, i + 4);
                    if (Character.isDigit(four.charAt(3))) {
                        array.add(dartResult.substring(i, i + 3));
                    } else {
                        array.add(four);
                    }
                } else {
                    String three = dartResult.substring(i, i + 3);
                    if (Character.isDigit(three.charAt(2))) {
                        array.add(dartResult.substring(i, i + 2));
                    } else {
                        array.add(three);
                    }
                }
            }
        }

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).length() == 3) {

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1S*2T*3S"));
    }
}
