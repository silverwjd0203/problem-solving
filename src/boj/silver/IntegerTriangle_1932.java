package boj.silver;

/* BOJ 1932 Silver 1 - 정수 삼각형 */

// 맨 위층부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IntegerTriangle_1932 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] triangle = new int[n][n];
    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j <= i; j++) {
        triangle[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // dp[i][j] = i번째 층 j번째 위치에 도달할 수 있는 최대 합
    // 각 위치에서 이전 층의 가능한 위치들 중 최댓값을 선택
    int[][] dp = new int[n][n];

    // 삼각형의 양 끝 위치의 경우
    // [i][0]: 오직 [i-1][0]에서만 올 수 있음
    // [i][i]: 오직 [i-1][i-1]에서만 올 수 있음

    // 삼각형의 중간 위치의 경우
    // [i][j]: [i-1][j-1] or [i-1][j]에서 올 수 있음

    // 초기값: 첫 번째 층
    dp[0][0] = triangle[0][0];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          // 왼쪽 끝: 위층의 왼쪽 끝에서만 올 수 있음
          dp[i][j] = dp[i - 1][0] + triangle[i][0];
        } else if (j == i) {
          // 오른쪽 끝: 위층의 오른쪽 끝에서만 올 수 있음
          dp[i][j] = dp[i - 1][i - 1] + triangle[i][j];
        } else {
          // 중간 위치: 위층의 두 위치 중 최댓값 선택
          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
        }
      }
    }
    // 마지막 층(n-1층)의 모든 위치 중 최댓값이 답
    int max = Arrays.stream(dp[n - 1]).max().orElse(0);
    System.out.println(max);
  }
}
