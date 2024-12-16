import java.util.*;

class Tuple {
    public int[] solution(String s) {
        List<Integer> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        // 양 끝의 괄호 제거
        String element = s.substring(1, s.length() - 1);
        
        StringBuilder sb = new StringBuilder();
        // 각 배열별로 분리
        for (int i = 0; i < element.length(); i++) {
            sb.append(Character.toString(element.charAt(i)));
            if (element.charAt(i) == '}') {
                i++;
                list.add(sb.toString());
                sb = new StringBuilder();
            } 
        }
        
        // 길이순으로 배열 정렬
        Collections.sort(list, (String e1, String e2) -> e1.length() - e2.length());
        
        int bigestNumber = 0;
        // 가장 큰 원소의 수 찾기
        String e = list.get(list.size() - 1);
        String commaE = e.substring(1, e.length() - 1);
        int[] listE = Arrays.stream(commaE.split(",")).mapToInt(Integer::parseInt).toArray();
        
        for (int i = 0; i < listE.length; i++) {
            if (bigestNumber < listE[i]) {
                bigestNumber = listE[i];
            }
        }
        
        boolean[] usedCheck = new boolean[bigestNumber + 1];
        for (String ele : list) {
            String commaEle = ele.substring(1, ele.length() - 1);
            int[] listEle = Arrays.stream(commaEle.split(",")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < listEle.length; i++) {
                if (!usedCheck[listEle[i]]) {
                    result.add(listEle[i]);
                    usedCheck[listEle[i]] = true;
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
