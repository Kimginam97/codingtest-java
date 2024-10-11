package org.example.b;

import java.util.HashMap;

// 19. 완주하지 못한 선수
public class Main19 {
    public String solution(String[] participant, String[] completion){
        // 1. 해시맵 생성
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 2. 완주한 선수들의 이름을 해시맵에 저장
        for(String string : completion){
            hashMap.put(string, hashMap.getOrDefault(string, 0)+1);
        }
        // 3. 참가한 선수들의 이름을 키로 하는 값을 1씩 감소
        for(String string : participant){
            // 4. 완주하지 못한 선수를 찾으면 반환
            if(hashMap.getOrDefault(string, 0)==0){
                return string;
            }
            hashMap.put(string, hashMap.get(string) - 1);
        }
        return null;
    }
}