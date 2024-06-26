package coding_test;

import java.io.*;
import java.util.*;

public class Coin {
    
    static int n;
    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[k + 1];

        for(int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = arr[i]; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        if(dp[k] == Integer.MAX_VALUE - 1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
