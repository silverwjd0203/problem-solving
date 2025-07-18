package boj.silver;

/* BOJ 1018 Silver 4 - 체스판 다시 칠하기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessboardRepainting_1018 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] board = new int[n][m]; // black = 0, white = 1
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = str.charAt(j) == 'B' ? 0 : 1;
      }
    }

    int min = Integer.MAX_VALUE;

    // 가능한 모든 8x8 영역 탐색
    for (int i = 0; i <= n - 8; i++) {
      for (int j = 0; j <= m - 8; j++) {
        // 양쪽 시작 색을 모두 고려해야 함
        int blackCnt = paint(i, j, board, true);
        int whiteCnt = paint(i, j, board, false);
        min = Math.min(min, Math.min(blackCnt, whiteCnt));
      }
    }

    System.out.println(min);
  }

  public static int paint(int x, int y, int[][] board, boolean isBlack) {
    int cnt = 0;
    for (int i = x; i < x + 8; i++) {
      for (int j = y; j < y + 8; j++) {
        // 체스판은 (i + j) % 2 == 0이면 시작색, 1이면 반대색이 되어야 함
        // isBlack이 true면 (i+j)가 짝수일 때 검은색
        // isBlack이 false면 (i+j)가 홀수일 때 검은색
        boolean shouldBeBlack = isBlack ? (i + j) % 2 == 0 : (i + j) % 2 == 1;
        int expectedColor = shouldBeBlack ? 0 : 1;

        if (board[i][j] != expectedColor) {
          cnt++;
        }
      }
    }
    return cnt;
  }
}
