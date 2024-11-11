package org.example.d;

import java.util.ArrayDeque;

// 37. 게임 맵 최단거리
public class Main37 {

    // 1. 이동할수 있는 방향을 나타내는 배열 rx, ry 선언
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static class Node{
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] maps){
        // 2. 맵의 크기를 저장하는 변수 선언
        int N = maps.length;
        int M = maps[0].length;

        // 3. 최단 거리를 저장할 배열 생성
        int[][] dist = new int[N][M];

        // 4. bfs 탐색을 위한 큐 생성
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // 5. 시작 정점에 대해서 큐에 추가, 최단 거리 저장
        queue.addLast(new Node(0,0));
        dist[0][0] = 1;

        // 6. queue가 빌 때까지 반복
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();

            // 7. 현재 위치에서 이동할수 있는 모든 방향
            for(int i = 0; i < 4; i++){
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                // 8. 맵 밖으로 나가는 경우 예외처리
                if(nr < 0 || nc < 0 || nr >= N || nc >= M){
                    continue;
                }

                // 9. 벽으로 가는 경우 예외처리
                if(maps[nr][nc] == 0){
                    continue;
                }

                // 10. 이동한 위치가 처음 방문하는 경우, queue에 추가하고 거리 갱신
                if(dist[nr][nc] == 0){
                    queue.addLast(new Node(nc,nr));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }

}
