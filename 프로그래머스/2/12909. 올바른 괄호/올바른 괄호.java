import java.util.*;
    class Solution {
        boolean solution(String s) {
            Stack<String> stack = new Stack<>();

            // String -> char로 변경 해서 바로 체크
            for (char c : s.toCharArray()) {
                if (c=='('){
                    // 얘는 바로넣어줌
                    stack.push("(");
                }else if (c==')'){
                    if (stack.isEmpty()){
                        return false;
                    }else {
                        stack.pop();
                    }

                }

            }
            return stack.isEmpty();
        }
    }