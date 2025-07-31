package boj.silver;

/* BOJ 2178 Silver 1 - 미로 탐색 */

// 1: 이동할 수 있는 칸, 0: 이동할 수 없는 칸
// 상하좌우 인접한 칸으로만 이동 가능

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeExplorer_2178 {

  static int n, m;
  static int[][] grid;
  static boolean[][] visited; // 상, 하, 좌, 우
  static int[][] result; // 시작 지점으로부터 현재 좌표까지의 최단 거리
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    grid = new int[n][m];
    visited = new boolean[n][m];
    result = new int[n][m];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        grid[i][j] = line.charAt(j) - '0';
      }
    }

    // 시작 위치
    int x = 0, y = 0;
    bfs(x, y);
    System.out.println(result[n - 1][m - 1]);
  }

  private static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;
    result[x][y] = 1;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      // 도착 위치에 도달하면 종료
      if (now[0] == n - 1 && now[1] == m - 1) {
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];
        // 미로 범위 안 + 아직 방문하지 않음 + 이동 가능해야 함
        if (isPossible(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1) {
          visited[nx][ny] = true;
          queue.offer(new int[]{nx, ny});
          // 현재 칸까지의 최단 거리 = 이전 칸의 거리 + 1
          result[nx][ny] = result[now[0]][now[1]] + 1;
        }
      }
    }
  }

  private static boolean isPossible(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
