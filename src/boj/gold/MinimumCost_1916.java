package boj.gold;

/* BOJ 1916 Gold 5 - 최소비용 구하기 */

// 다익스트라
// 음이 아닌 가중치가 있는 그래프에서 한 정점에서 다른 모든 정점까지의 최단 경로를 찾는 알고리즘

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumCost_1916 {

  static int n, m;
  static List<List<Bus>> graph = new ArrayList<>();
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    // dist[i] = 시작점에서 정점 i까지의 최단거리
    dist = new int[n + 1];
    // dist 배열 초기화
    Arrays.fill(dist, Integer.MAX_VALUE);

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      graph.get(s).add(new Bus(e, cost));
    }

    st = new StringTokenizer(br.readLine(), " ");
    int s = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    dijkstra(s);
    System.out.println(dist[e]);
  }

  static void dijkstra(int start) {
    PriorityQueue<Bus> pq = new PriorityQueue<>();
    pq.offer(new Bus(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Bus now = pq.poll();
      if (now.cost > dist[now.vertex]) { // 이미 더 적은 비용이 드는 경로가 존재
        continue;
      }

      // 인접한 정점들을 확인
      for (Bus next : graph.get(now.vertex)) {
        int cost = dist[now.vertex] + next.cost;

        if (cost < dist[next.vertex]) {
          // 더 짧은 경로를 찾았다면 dist 갱신
          dist[next.vertex] = cost;
          pq.offer(new Bus(next.vertex, cost));
        }
      }
    }
  }

  static class Bus implements Comparable<Bus> {

    int vertex;
    int cost;

    public Bus(int vertex, int cost) {
      this.vertex = vertex;
      this.cost = cost;
    }

    @Override
    public int compareTo(Bus o) {
      return Integer.compare(this.cost, o.cost);
    }
  }
}
