package boj.silver;

/* BOJ 11727 Silver 3 - 2xn 타일링 2 */

// 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling2xN2_11727 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    if (n == 1) {
      System.out.println(1);
      return;
    }
    if (n == 2) {
      System.out.println(3);
      return;
    }

    int[] dp = new int[n + 1];

    dp[1] = 1; // 2×1 1개
    dp[2] = 3; // 2×1 2개, 1×2 2개, 2×2 1개

    // 가로 타일(1×2) 2개를 위아래로 (타일 2개 너비 차지) > 남은 공간: 2×(n-2) → dp[n-2]가지 방법
    // 정사각형 타일 (2×2) 1개 > 남은 공간: 2×(n-2) → dp[n-2]가지 방법
    // 세로 타일(2×1) 1개 (타일 1개 너비 차지) > 남은 공간: 2×(n-1) → dp[n-1]가지 방법
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
    }

    System.out.println(dp[n]);
  }
}
