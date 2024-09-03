package org.example;

import java.util.Arrays;
import java.util.Collections;

// 2번 배열 제어하기
public class Main02 {

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[]{4,2,2,1,3,4})));
        System.out.println(Arrays.toString(solution(new int[]{2,1,1,3,2,5,4})));
    }


    private static int[] solution(int[] arr){
        // 중복값 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

        System.out.println("중복값 제거: "+Arrays.toString(result));

        // 내림차순 정렬
        Arrays.sort(result, Collections.reverseOrder());

        // int형 배열로 변경후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
