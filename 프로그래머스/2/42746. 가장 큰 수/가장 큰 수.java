import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {

        // 1. 정수 배열을 문자열 리스트로 변환
        // 숫자를 문자열로 바꿔야 나중에 연결(concatenate) 비교가 가능함
        List<String> strNumbers = Arrays.stream(numbers)
                                        .mapToObj(String::valueOf) // 각 숫자를 문자열로 변환
                                        .collect(Collectors.toList());

        // 2. 문자열 리스트를 사용자 정의 기준으로 정렬
        // 비교 기준: 두 문자열 a, b를 붙였을 때 (b+a)와 (a+b)를 비교
        // b+a가 a+b보다 크면 b를 먼저 오게 함 → 가장 큰 수를 만들기 위해 내림차순 정렬
        strNumbers.sort((num1, num2) -> (num2 + num1).compareTo(num1 + num2));

        // 3. 모든 숫자가 0인 경우 처리
        // 예: [0,0,0] → 결과는 "0"이어야 함
        if (strNumbers.isEmpty() || strNumbers.get(0).equals("0")) {
            return "0";
        }

        // 4. 정렬된 문자열 리스트를 하나의 문자열로 합치기
        return String.join("", strNumbers);
    }
}
