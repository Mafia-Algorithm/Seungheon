package coding_test;

import java.io.*;
import java.util.*;

public class Tower {

    static class TowerInfo {
        int number;
        int height;
        
        public TowerInfo(int number, int height) {
            this.number = number;
            this.height = height;
        }
    }
           
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Stack<TowerInfo> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                answer.append("0 ");
                stack.push(new TowerInfo(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        answer.append("0 ");
                        stack.push(new TowerInfo(i, height));
                        break;
                    }

                    TowerInfo tower = stack.peek();

                    if (tower.height > height) {
                        answer.append(tower.number + " ");
                        stack.push(new TowerInfo(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
    }
}
