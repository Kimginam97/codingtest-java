package org.example;

import java.util.Arrays;
import java.util.Collections;

// 2번 배열 제어하기
public class Main02 {
    private static int[] solution(int[] arr){
        // 중복값 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

        System.out.println("중복값 제거: "+result);

        // 내림차순 정렬
        Arrays.sort(result, Collections.reverseOrder());

        // int형 배열로 변경후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
