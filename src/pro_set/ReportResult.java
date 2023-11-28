package pro_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, ArrayList<String>> reportedUserMap = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (String data : report) {
            String[] splitData = data.split(" ");
            String reportUser = splitData[0];
            String reportedUser = splitData[1];

            if (countMap.containsKey(reportedUser)) {
                ArrayList<String> arrayList = reportedUserMap.get(reportedUser);
                if (arrayList.contains(reportUser)) {
                    continue;
                }
                countMap.put(reportedUser, countMap.get(reportedUser) + 1);
                reportedUserMap.get(reportedUser).add(reportUser);
            } else {
                countMap.put(reportedUser, 1);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(reportUser);
                reportedUserMap.put(reportedUser, arrayList);
            }
        }

        for (String s : id_list) {
            if (countMap.containsKey(s) && countMap.get(s) >= k) {
                ArrayList<String> arrayList = reportedUserMap.get(s);
                for (int j = 0; j < arrayList.size(); j++) {
                    String user = arrayList.get(j);
                    int index = Arrays.asList(id_list).indexOf(user);
                    answer[index]++;
                }
            }
        }

        return answer;
    }
}
