package boj.silver;

/* BOJ 2579 Silver 3 - 계단 오르기 */

// 연속된 세 개의 계단을 모두 밟아서는 안 됨
// 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있음
// 마지막 도착 계단은 반드시 밟아야 함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs_2579 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] stairs = new int[n];
    for (int i = 0; i < n; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    // 계단이 1개뿐이면 그 계단을 밟는 방법만 존재
    if (n == 1) {
      System.out.println(stairs[0]);
      return;
    }

    // 어떤 계단에 도착했을 때, 2가지 경우가 있음
    // 바로 직전 계단을 밟고 왔음 (한 칸 올라옴)
    // 직전 계단을 건너뛰고 왔음 (두 칸 올라옴)

    // 만약 직전 계단을 밟고 왔다면 → 그 다음엔 반드시 한 칸 건너뛰어야 함
    // 만약 직전 계단을 안 밟고 왔다면 → 그 다음엔 연속으로 밟아도 됨

    int[][] dp = new int[n][2];

    // dp[i][0]: i번째 계단을 밟을 때, 직전 계단(i-1)도 밟은 경우
    // dp[i][1]: i번째 계단을 밟을 때, 직전 계단(i-1)은 건너뛴 경우

    dp[0][0] = stairs[0];
    dp[0][1] = stairs[0];

    dp[1][0] = stairs[0] + stairs[1];  // 1번 → 2번
    dp[1][1] = stairs[1]; // 시작 → 2번

    // 점화식
    for (int i = 2; i < n; i++) {
      // 만약 i-1번째도 한 칸 점프로 왔다면 → i-2, i-1, i 연속 3개를 밟게 됨
      // i-1번째는 반드시 두 칸 점프로 와야 함
      dp[i][0] = dp[i-1][1] + stairs[i];
      // i-2까지 한 칸 점프로 왔든, 두 칸 점프로 왔든 상관없음
      // i-1은 밟지 않았으므로 연속 3개가 될 수 없음
      dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i];  // 두 칸 점프
    }

    // 마지막 계단은 반드시 밟아야 하므로 둘 중 최댓값
    System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
  }
}
