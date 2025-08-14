package boj.silver;

/* BOJ 11660 Silver 1 - 구간 합 구하기 5 */

/*
 *  2D 누적합 사용 시 가장 효율적
 *  구간 (x1,y1)~(x2,y2)의 합 =
 *  전체 영역 - 위쪽 불필요 영역 - 왼쪽 불필요 영역 + 중복 제거된 영역
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RangeSum5_11660 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j <= n; j++) {
        // 기존 풀이(행 단위 누적합)
        // arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());

        // 2D 누적합 사용
        // 현재 값 + 위쪽 누적합 + 왼쪽 누적합 - 겹치는 부분
        arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      // 기존 풀이: 각 행별로 y1 ~ y2 부분합을 더함
      // int sum = 0;
      // for (int j = x1; j <= x2; j++) {
      //   sum += arr[j][y2] - arr[j][y1 - 1];
      // }

      int sum = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1];

      sb.append(sum).append("\n");
    }
    System.out.print(sb);
  }
}
