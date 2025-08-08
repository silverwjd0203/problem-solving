package boj.silver;

/* BOJ 21736 Silver 2 - 헌내기는 친구가 필요해 */

// O는 빈 공간, X는 벽, I는 도연이, P는 사람
// 벽은 통과할 수 없고, 빈 공간과 사람이 있는 곳은 이동 가능

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UpperclassmanNeedsFriends_21736 {

  static int n, m, cnt;
  static char[][] grid;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    grid = new char[n][m];
    visited = new boolean[n][m];

    int x = 0, y = 0;

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        char c = str.charAt(j);
        grid[i][j] = c;
        if (c == 'I') { // 도연이의 위치 = 시작점
          x = i;
          y = j;
        }
      }
    }
    bfs(x, y);
    System.out.println(cnt == 0 ? "TT" : cnt);
  }

  private static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];
        if(isPossible(nx, ny) && !visited[nx][ny]) {
          queue.offer(new int[]{nx, ny});
          visited[nx][ny] = true;
          if(grid[nx][ny] == 'P') { // 해당 위치에 사람이 있는 경우
            cnt++;
          }
        }
      }
    }
  }

  private static boolean isPossible(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != 'X'; // 벽이 있으면 이동 불가
  }
}
