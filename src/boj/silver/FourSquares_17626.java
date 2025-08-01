package boj.silver;

/* BOJ 17626 Silver 3 - Four Squares */

// n을 1², 2², 3², ..., k²와 같은 제곱수들의 합으로 표현할 수 있음
// 자연수 n이 주어질 때, n을 최소 개수의 제곱수 합으로 표현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FourSquares_17626 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // dp[i] = 숫자 i를 만드는데 필요한 최소 제곱수 개수
    int[] dp = new int[n + 1];
    // 모든 값을 최댓값으로 초기화 (나중에 최솟값으로 갱신하기 위함)
    Arrays.fill(dp, Integer.MAX_VALUE);

    // i가 13인 경우 (1², 2², 3²까지 가능)
    // 13 - 1 = 12 → dp[12] + 1
    // 13 - 4 = 9 → dp[9] + 1
    // 13 - 9 = 4 → dp[4] + 1
    // 이 중에서 가장 작은 값이 dp[13]이 됨

    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);

      }
    }

    System.out.println(dp[n]);
  }
}
