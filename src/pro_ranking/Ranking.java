package pro_ranking;

import java.util.Arrays;

public class Ranking {
    public static int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];
        String[][] splitInfo = new String[info.length][5];
        for (int i = 0; i < info.length; i++) {
            splitInfo[i] = info[i].split(" ");
        }

        String[][] splitQuery = new String[query.length][5];
        for (int i = 0; i < query.length; i++) {
            String[] tmp = query[i].split(" and ");
            String[] tmpSplit = tmp[3].split(" ");
            splitQuery[i][0] = tmp[0];
            splitQuery[i][1] = tmp[1];
            splitQuery[i][2] = tmp[2];
            splitQuery[i][3] = tmpSplit[0];
            splitQuery[i][4] = tmpSplit[1];
        }

        for (int i = 0; i < splitQuery.length; i++) {
            String[] selectedQuery = splitQuery[i];
            for (int j = 0; j < splitInfo.length; j++) {
                String[] selectedPerson = splitInfo[j];
                boolean isSelected = true;
                for (int k = 0; k < 4; k++) {
                    if (selectedQuery[k].equals("-")) {
                        continue;
                    }

                    if (!selectedQuery[k].equals(selectedPerson[k])) {
                        isSelected = false;
                        break;
                    }
                }

                if (Integer.parseInt(selectedQuery[4]) > Integer.parseInt(selectedPerson[4])) {
                    isSelected = false;
                }

                if (isSelected) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        }, new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        })));
    }
}
