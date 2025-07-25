package boj.silver;

/* BOJ 11726 Silver 3 - 2xn 타일링 */

// 2×n 크기의 직사각형을 채우는 방법의 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling2xN_11726 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];

    if (n == 1) {
      System.out.println(1);
      return;
    }
    if (n == 2) {
      System.out.println(2);
      return;
    }

    // 맨 오른쪽 열을 채우는 방법
    // 가로 타일(1×2) 2개를 위아래로 (타일 2개 너비 차지) > 남은 공간: 2×(n-2) → dp[n-2]가지 방법
    // 세로 타일(2×1) 1개 (타일 1개 너비 차지) > 남은 공간: 2×(n-1) → dp[n-1]가지 방법
    // 모든 경우의 수 = dp[n-2] + dp[n-1]

    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
      // 모듈러 연산 (a+b) % m = ((a % m) + (b % m)) % m
      // 중간에 a와 b를 각각 m으로 나눈 나머지를 구해도, 마지막에 한 번만 m으로 나눈 것과 결과가 같음
    }

    System.out.println(dp[n]);
  }
}
