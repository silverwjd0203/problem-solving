package boj.silver;

/* BOJ 2667 Silver 1 - 단지번호 붙이기 */

// 1은 집이 있는 곳, 0은 집이 없는 곳
// 상하좌우로 연결된 집들을 하나의 단지로 봄

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ComplexNumbering_2667 {

  static int n;
  static int[][] grid;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < n; j++) {
        grid[i][j] = str.charAt(j) - '0';
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // 아직 방문하지 않았고 집이 있는 위치라면 새로운 단지 시작
        if(!visited[i][j] && grid[i][j] == 1) {
          int res = bfs(i, j);
          list.add(res);
        }
      }
    }
    // 단지 내 집의 개수를 오름차순으로 정렬
    list.sort(Integer::compareTo);
    StringBuilder sb = new StringBuilder();
    for(int i : list) {
      sb.append(i).append("\n");
    }
    System.out.println(list.size());
    System.out.print(sb);
  }

  private static int bfs(int x, int y) {
    int cnt = 1;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];

        if (isPossible(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1) {
          queue.offer(new int[]{nx, ny});
          visited[nx][ny] = true;
          cnt++;
        }
      }
    }
    return cnt;
  }

  private static boolean isPossible(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }
}
