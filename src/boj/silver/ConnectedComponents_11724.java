package boj.silver;

/* BOJ 11724 Silver 2 - 연결 요소의 개수 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ConnectedComponents_11724 {

  static List<List<Integer>> graph = new ArrayList<>();
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken()); // 정점의 개수
    int m = Integer.parseInt(st.nextToken()); // 간선의 개수

    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        bfs(i);
        cnt++;
      }
    }

    System.out.println(cnt);
  }


  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int neighbor : graph.get(now)) {
        if (!visited[neighbor]) {
          queue.offer(neighbor);
          visited[neighbor] = true;
        }
      }
    }
  }

  private static void dfs(int start) {
    visited[start] = true;  // 현재 노드를 방문 처리

    // 현재 노드와 연결된 모든 인접 노드들을 확인
    for (int neighbor : graph.get(start)) {
      if (!visited[neighbor]) {
        dfs(neighbor);  // 재귀적으로 DFS 수행
      }
    }
  }
}
