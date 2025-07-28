package boj.silver;

/* BOJ 2630 Silver 3 - 색종이 만들기 */

// 전체 영역이 같은 색이 아니면 4등분하여 각각을 재귀적으로 처리
// 영역이 모두 같은 색이면 해당 색 카운트 증가

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeOrigami_2630 {

  static int whiteCnt;
  static int blueCnt;
  static int[][] paper;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    paper = new int[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    recursive(n, 0, 0); // 전체 영역부터 시작

    System.out.println(whiteCnt);
    System.out.println(blueCnt);
  }


  // startX: 행 인덱스, startY: 열 인덱스
  private static void recursive(int num, int startRow, int startCol) {
    if (isSameColor(startRow, startCol, num)) {
      if (paper[startRow][startCol] == 0) {  // 흰색
        whiteCnt++;
      } else {  // 파란색
        blueCnt++;
      }
      return; // 더 이상 분할하지 않고 종료
    }

    int half = num / 2;

    // 4등분된 각 영역을 재귀적으로 처리
    recursive(half, startRow, startCol); // 왼쪽 위
    recursive(half, startRow, startCol + half); //오른쪽 위
    recursive(half, startRow + half, startCol); // 왼쪽 아래
    recursive(half, startRow + half, startCol + half); // 오른쪽 아래
  }

  // 주어진 영역이 모두 같은 색인지 확인
  private static boolean isSameColor(int startRow, int startCol, int size) {
    int first = paper[startRow][startCol];

    // 영역 내 모든 칸을 확인
    for (int i = startRow; i < startRow + size; i++) {
      for (int j = startCol; j < startCol + size; j++) {
        if (paper[i][j] != first) {
          return false;  // 다른 색이 존재
        }
      }
    }
    return true;  // 모두 같은 색
  }
}
