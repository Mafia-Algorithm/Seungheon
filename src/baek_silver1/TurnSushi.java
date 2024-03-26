package baek_silver1;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TurnSushi {

    static int N, d, k, c;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] sushiList = new int[N + k - 1];
        for (int i = 0; i < N; i++) {
            sushiList[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N; i < sushiList.length; i++) {
            int index = i - N;
            sushiList[i] = sushiList[index];
        }

        for (int i = 0; i < N; i++) {
            int[] tmp = Arrays.copyOfRange(sushiList, i, i + k);
            Set<Integer> tmpSet = new HashSet<>(Arrays.asList(Arrays.stream(tmp).boxed().toArray(Integer[]::new)));

            int count = tmpSet.size();
            if (!tmpSet.contains(c)) count++;

            if (count > max) max = count;
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
