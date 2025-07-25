package boj.silver;

/* BOJ 1012 Silver 2 - 유기농 배추 */

// 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)
// 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50)
// 서로 연결된 배추들은 하나의 덩어리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage_1012 {

  static int n, m, wormCnt;
  static int[][] grid;
  static boolean[][] visited;
  // 상, 하, 좌, 우
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken()); // 가로 길이 = 헹
      n = Integer.parseInt(st.nextToken()); // 세로 길이 = 열
      int cnt = Integer.parseInt(st.nextToken());

      grid = new int[n][m];
      visited = new boolean[n][m];
      wormCnt = 0;

      for (int i = 0; i < cnt; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        grid[y][x] = 1; // 배추 표시 (x: 행, y: 열)
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (!visited[i][j] && grid[i][j] == 1) {
            bfs(i, j);
            wormCnt++; // BFS가 끝날 때마다 지렁이를 1 증가
          }
        }
      }
      sb.append(wormCnt).append("\n");
    }
    System.out.print(sb);
  }

  private static void bfs(int x, int y) {
    Queue<Field> queue = new LinkedList<>();
    queue.offer(new Field(x, y));
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      Field now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        if (isPossible(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1) {
          visited[nx][ny] = true;
          queue.offer(new Field(nx, ny));
        }
      }
    }
  }

  private static boolean isPossible(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m; // 배추밭의 범위를 넘어가지 않아야 함
  }

  static class Field {

    int x, y;

    public Field(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
