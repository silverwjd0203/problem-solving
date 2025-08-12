package boj.silver;

/* BOJ 1149 Silver 1 - RGB 거리 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBStreet_1149 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // arr[i] : 각 집의 빨강, 초록, 파랑으로 칠하는 비용
    int[][] arr = new int[n][3];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // dp[i][j] : i번째 집을 j색으로 칠했을 때까지의 최소 비용
    int[][] dp = new int[n][3];
    dp[0] = arr[0]; // 첫 번째 집은 각 색깔별 비용이 그대로 최소 비용

    // 이전 집의 가능한 색깔 중 최소 비용을 선택
    for (int i = 1; i < n; i++) {
      // i번째 집을 0번 색(빨강)으로 칠하려면, 이전 집은 1번(초록) 또는 2번(파랑)이어야 함
      dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
      // i번째 집을 1번 색(초록)으로 칠하려면, 이전 집은 0번(빨강) 또는 2번(파랑)이어야 함
      dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
      // i번째 집을 2번 색(파랑)으로 칠하려면, 이전 집은 0번(빨강) 또는 1번(초록)이어야 함
      dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
    }

    int min = Integer.MAX_VALUE;
    for (int cost : dp[n - 1]) {
      min = Math.min(min, cost);
    }

    System.out.println(min);
  }
}
