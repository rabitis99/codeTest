import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer =new ArrayList<>();

        Stack<Integer> integerStack =new Stack<>();
        integerStack.add(10);
        for (int ele: arr){
            if (integerStack.peek()!= ele){
                integerStack.add(ele);
                answer.add(ele);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}