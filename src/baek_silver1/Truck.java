package baek_silver1;

import java.io.*;
import java.util.*;

public class Truck {

    static int n, w, L;
    static int index = 0;
    static int bridgeWeight = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            right.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> rightCopy = List.copyOf(right);

        HashMap<Integer, Integer> bridge = new HashMap<>();

        while (left.size() != n) {
            Iterator<Map.Entry<Integer, Integer>> iterator = bridge.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> truck = iterator.next();
                truck.setValue(truck.getValue() + 1);
                if (truck.getValue() > w) {
                    left.add(truck.getValue());
                    bridgeWeight -= rightCopy.get(truck.getKey());
                    iterator.remove();
                }
            }

            if (!right.isEmpty()) {
                if (bridgeWeight + right.get(0) <= L && bridge.size() <= w) {
                    bridge.put(index, 1);
                    bridgeWeight += right.get(0);
                    right.remove(0);
                    index++;
                }
            }

            count++;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
