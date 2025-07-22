import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 1번 해쉬생성
        HashMap<Integer,Integer> number =new HashMap<>();
        
        // 2번 해쉬(키,값 배정)
        for (Integer i: nums){
            number.put(i,number.getOrDefault(i,0)+1);
        }
        // 3번 전체 크기랑 해쉬 키 갯수 비교
        int size= nums.length/2;
        int keys= number.size();
        
        answer=Math.min(size,keys);
        
        return answer;
    }
}