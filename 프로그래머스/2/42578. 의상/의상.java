import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 의류 분류
        HashMap<String,Integer> clothe=new HashMap<>();
        // 종류 별 갯수(의상의 종류)
       for (int i=0; i< clothes.length; i++){
           String clo= clothes[i][1];
           clothe.put(clo,clothe.getOrDefault(clo,0)+1);
       }
       // 의상의 총 조합 갯수
        for (int kinds: clothe.values()){
            answer *=kinds+1;
        }
        
       return answer-1;
    }
}