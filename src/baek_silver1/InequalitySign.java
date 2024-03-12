package baek_silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InequalitySign {

    static int n;
    static boolean[] visited;
    static String[] arr;
    static List<String> list = new ArrayList<>();

    static void dfs(String num, int idx) {
        if (idx == n + 1) {
            list.add(num);
            return;
        }

        for (int j = 0; j < 10; j++) {
            if (visited[j]) continue;

            if (idx == 0 || ckeck(Character.getNumericValue(num.charAt(idx - 1)), j, arr[idx - 1])) {
                visited[j] = true;
                dfs(num + j, idx + 1);
                visited[j] = false;
            }
        }
    }

    static boolean ckeck(int a, int b, String c) {
        if (c.equals(">")) {
            return a >= b;
        } else if (c.equals("<")) {
            return a <= b;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");

        visited = new boolean[10];

        dfs("", 0);

        System.out.print(list.get(list.size() - 1) + "\n");
        System.out.print(list.get(0));

    }
}
