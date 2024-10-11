package org.example.a;

import java.util.ArrayDeque;
import java.util.HashMap;

// 10. 괄호 회전하기
public class Main10 {
    public static int solution(String s){
        // 1. 괄호 정보를 저장함. 코드를 간결하게 할수 있다.
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        int n = s.length(); // 원본 문자열의 길이 저장
        s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만들어줌
        int answer = 0;

        // 2. 확인할 문자열의 시작 인덱스를 0부터 n까지 이동
        A:for(int i = 0; i<n; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            // 3. i(시작위치)부터 원본 문자열의 길이의 n개까지 올바른 괄호 문자열인지 확인
            for(int j = i; j < i; j++){
                char c = s.charAt(j);
                // 해시맵 안에 해당 키가 없다면 열리는 괄호
                if(!map.containsKey(c)){
                    stack.push(c);
                }else{
                    // 4. 짝이 맞지 않으면 내부 for문은 종료하고 for문 A로 이동
                    if(stack.isEmpty() || stack.pop().equals(map.get(c))){
                        continue A;
                    }
                }
            }
            // 5. 3에서 continue 되지 않았고, 스택이 비어있으면 올바른 괄호 문자열
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}
