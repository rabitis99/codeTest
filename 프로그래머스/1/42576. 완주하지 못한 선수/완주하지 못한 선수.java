
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
       //문제는 해시맵이 아니라는 점인데..

        // 1번 알파벳순으로 나열
        List<String> part= Arrays.stream(participant).sorted().collect(Collectors.toList());
        List<String> com= Arrays.stream(completion).sorted().collect(Collectors.toList());

        for (int i=0; i<com.size();i++){
            // 2번 순차적으로 내려오면서 동일하지 않으면 return
            if (!part.get(i).equals(com.get(i))) {
                return part.get(i);
            }
        }

        return part.get(part.size()-1);
    }
}
