import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 접두어 찾기:
        // 시작 순서대로 배열
        Arrays.sort(phone_book);

        // 짧은 얘 부터 for문으로 돌려버려서 찾기
        for (int i= 1; i< phone_book.length; i++){
            if (phone_book[i].startsWith(phone_book[i-1])){
                answer=false;
                break;
            }
            
        }
        return answer;
    }
}