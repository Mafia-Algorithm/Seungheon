package baek_19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hamburger {

    static int N;
    static int K;
    static String[] table;
    static boolean[] isEat;
    static int eatPerson = 0;

    static boolean bergerCheck(int index){
        if(table[index].equals("H")){		//햄버거가 맞을 때
            table[index] = "X";	//햄버거 먹었기 때문에 'X'로 변경
            eatPerson++;		//먹은 인원수 증가!
            return true;	//먹기 성공 True
        }
        return false;		//먹기 실패 False
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        K = input[1];

        table = br.readLine().split("");
        isEat = new boolean[N];

        // 테이블 순회
        for (int i = 0; i < N; i++) {
            // 사람이면
            if (table[i].equals("P")) {
                int index = Math.max(i - K, 0);
                boolean check = false;
                //먹을 수 있는 햄버거 왼쪽 범위 탐색
                //가장 먼저 발견한 햄버거가 범위 왼쪽에 가장 가까운 햄버거!
                for(int j=index;j<i;j++){
                    if(bergerCheck(j)){	//먹을 수 있는 햄버거 발견
                        check = true;
                        break;
                    }
                }
                //먹을 수 있는 햄버거 오른쪽 범위 탐색
                if(!check){
                    index = i + K >= N ? N-1 : i + K;
                    for(int j=i+1;j<=index;j++){
                        if(bergerCheck(j))	//먹을 수 있는 햄버거 발견
                            break;
                    }
                }
            }
        }

        System.out.println(eatPerson);
    }
}
