package boj.silver;

/* BOJ 9461 Silver 3 - 파도반 수열 */

// P(1) = P(2) = P(3) = 1
// P(n) = P(n-2) + P(n-3) 점화식 적용 >> DP(다이나믹 프로그래밍)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadovanSequence_9461 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    long[] arr = new long[101];

    arr[1] = 1;
    arr[2] = 1;
    arr[3] = 1;

    for (int i = 4; i < 101; i++) {
      arr[i] = arr[i - 3] + arr[i - 2];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(arr[n]).append("\n");
    }

    System.out.print(sb);
  }
}
