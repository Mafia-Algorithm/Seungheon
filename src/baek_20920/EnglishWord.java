package baek_20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EnglishWord {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        HashMap<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            // 바로 외울 수 있는 단어면 패스
            if (word.length() < M) {
                continue;
            }

            // 처음 보는 단어
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);

            // 본적이 있는 단어
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }

        List<String> words = new ArrayList<>(wordMap.keySet());

        words.sort((o1, o2) -> {
            int c1 = wordMap.get(o1);
            int c2 = wordMap.get(o2);

            if(c1 == c2){
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에
                }
                return o2.length() - o1.length(); // 해당 단어의 길이가 길수록 앞에
            }
            return c2 - c1; // 자주 나오는 단어일수록 앞에
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }

        System.out.print(sb);
    }
}
