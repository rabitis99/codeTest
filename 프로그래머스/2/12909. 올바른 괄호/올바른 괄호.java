import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c); // 여는 괄호는 스택에 넣음
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호가 왔는데 짝이 없으면 false
                }
                stack.pop(); // 짝이 맞으면 하나 꺼냄
            }
        }

        return stack.isEmpty(); // 스택이 비어야 완전하게 짝이 맞음
    }
}
