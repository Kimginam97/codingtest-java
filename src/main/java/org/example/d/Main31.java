package org.example.d;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

// 31. 포켓몬
public class Main31 {
    public int solution(int[] nums){
        // 1. nums 리스테에서 중복을 제거한 집합(set)을 구함
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        // 2. 포켓몬의 총 수
        int n = nums.length;

        // 3. 선택할 포켓몬의 수
        int k = n / 2;

        // 4. 중복을 제거한 포켓몬의 종류 수와 선택할 포켓몬의 수 중 작은값 반환
        return Math.min(k, set.size());
    }
}
