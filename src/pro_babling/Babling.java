package pro_babling;

public class Babling {

    public static int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++) {
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")) {
                continue;
            }

            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");

            if(babbling[i].isEmpty()) answer++;

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}
        ));
    }
}