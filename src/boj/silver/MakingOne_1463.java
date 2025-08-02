package boj.silver;

/* BOJ 1463 Silver 3 - 1로 만들기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakingOne_1463 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n + 1];

    dp[1] = 0;

    // dp[i]는 i를 1로 만들기 위해 연산을 사용하는 횟수의 최솟값
    // 2부터 n까지의 최소 연산 횟수를 차례대로 구함
    for (int i = 2; i <= n; i++) {
      // 기본 연산: 1을 빼는 연산 (i - 1)
      dp[i] = dp[i - 1] + 1;

      // 만약 i가 2로 나누어지면, i / 2로 오는 경로도 고려
      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      }

      // 만약 i가 3으로 나누어지면, i / 3로 오는 경로도 고려
      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      }
    }

    System.out.println(dp[n]);
  }
}
