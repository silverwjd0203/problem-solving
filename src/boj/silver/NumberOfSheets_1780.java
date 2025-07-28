package boj.silver;

/* BOJ 1780 Silver 2 - 종이의 개수 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfSheets_1780 {

  static int[][] sheet;
  static int[] result = new int[3]; // -1, 0, 1로 채워진 종이의 개수 담을 배열

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    sheet = new int[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        sheet[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    recursive(n, 0, 0);

    StringBuilder sb = new StringBuilder();
    for (int i : result) {
      sb.append(i).append("\n");
    }

    System.out.print(sb);
  }

  private static void recursive(int num, int startRow, int startCol) {
    if (isSameNum(startRow, startCol, num)) {
      if (sheet[startRow][startCol] == -1) {
        result[0]++;
      } else if (sheet[startRow][startCol] == 0) {
        result[1]++;
      } else {
        result[2]++;
      }
      return; // 더 이상 분할하지 않고 종료
    }

    int third = num / 3;

    // 9개의 재귀 호출 (9등분: 3×3 격자로 나누는 것)
    recursive(third, startRow, startCol);
    recursive(third, startRow, startCol + third);
    recursive(third, startRow, startCol + 2 * third);
    recursive(third, startRow + third, startCol);
    recursive(third, startRow + third, startCol + third);
    recursive(third, startRow + third, startCol + 2 * third);
    recursive(third, startRow + 2 * third, startCol);
    recursive(third, startRow + 2 * third, startCol + third);
    recursive(third, startRow + 2 * third, startCol + 2 * third);
  }

  private static boolean isSameNum(int startRow, int startCol, int size) {
    int first = sheet[startRow][startCol];

    // 영역 내 모든 칸을 확인
    for (int i = startRow; i < startRow + size; i++) {
      for (int j = startCol; j < startCol + size; j++) {
        if (sheet[i][j] != first) {
          return false;  // 다른 숫자가 존재
        }
      }
    }
    return true;  // 모두 같은 색
  }
}
