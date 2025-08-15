package boj.silver;

/* BOJ 1992 Silver 1 - 쿼드트리 */

// 분할정복

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree_1992 {

  static int[][] grid;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    grid = new int[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        grid[i][j] = s.charAt(j) - '0';
      }
    }
    sb = new StringBuilder();

    recursive(0, 0, n);
    System.out.println(sb);
  }

  private static void recursive(int startX, int startY, int num) {
    // 현재 영역이 모두 같은 값이면 그 값만 출력
    if (isSame(startX, startY, num)) {
      sb.append(grid[startX][startY]);
      return;
    }

    int half = num / 2;

    sb.append("(");
    // 왼쪽 위
    recursive(startX, startY, half);
    // 오른쪽 위
    recursive(startX, startY + half, half);
    // 왼쪽 아래
    recursive(startX + half, startY, half);
    // 오른쪽 아래
    recursive(startX + half, startY + half, half);
    sb.append(")");
  }

  // 주어진 영역이 모두 동일한 숫자인지 확인
  private static boolean isSame(int startX, int startY, int num) {
    int first = grid[startX][startY];

    // 영역 내 모든 칸을 확인
    for (int i = startX; i < startX + num; i++) {
      for (int j = startY; j < startY + num; j++) {
        if (grid[i][j] != first) {
          return false;  // 다른 숫자 존재
        }
      }
    }
    return true;  // 모두 같은 숫자
  }
}
