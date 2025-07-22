package boj.silver;

/* BOJ 2606 Silver 3 - 바이러스 */

// 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸림
// BFS(너비우선탐색)과 DFS(깊이우선탐색)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus_2606 {

  static List<List<Integer>> graph = new ArrayList<>(); // → List<Integer>[] 사용 가능
  static boolean[] visited; // 방문 여부 체크 배열
  static int cnt;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
    int m = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    StringTokenizer st;
    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      // 양방향 연결
      graph.get(s).add(e);
      graph.get(e).add(s);
    }

    int start = 1; // 1번 컴퓨터가 웜 바이러스에 걸림
    bfs(start);
    System.out.println(cnt);
  }

  private static void bfs (int start) {
    Queue<Integer> queue = new LinkedList<>();
    // 시작 노드 추가 및 방문 처리
    queue.offer(start);
    visited[start] = true;

    while(!queue.isEmpty()) {
      int curr = queue.poll();

      // 현재 노드에 연결된 모든 인접 노드 확인
      for(int next : graph.get(curr)) {
        if(!visited[next]) {
          queue.offer(next);
          visited[next] = true;
          cnt++; // 감염 컴퓨터 수 증가
        }
      }
    }
  }
}
