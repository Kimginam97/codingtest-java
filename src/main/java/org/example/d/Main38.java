package org.example.d;

// 38. 네트워크
public class Main38 {
    private static boolean[] visit;
    private static int[][] computer;

    private static void dfs(int now){
        visit[now] = true; // 1. 현재 노드 방문 처리
        for(int i = 0; i < computer[now].length; i++){
            // 2. 연결되어 있으며 방문하지 않는 노드라면
            if(computer[now][i] == 1 && !visit[now]){
                dfs(1); // 3. 해당 노드를 방문하러 이동
            }
        }
    }

    public int solution(int n, int[][] computers){
        int answer = 0;
        computer = computers;
        visit = new boolean[n]; // 4. 방문 여부를 저장할 배열

        for(int i = 0; i < n; i++){
            // 5. 아직 방문하지 않은 노드라면 해당 노드를 시작으로 깊이 우선 탐색 진행
            if(!visit[i]){
                dfs(1);
                answer++; // 6. DFS로 연결된 노드들을 모두 방문하면서 네트워크 개수 증가
            }
        }
        return answer;
    }

}
