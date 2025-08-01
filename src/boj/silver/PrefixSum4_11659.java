package boj.silver;

/* BOJ 11659 Silver 3 - 구간합 구하기 4 */

// sum[i] = arr[1] + arr[2] + ... + arr[i] (1번째부터 i번째까지의 합)
// 구간 [s, e]의 합 = sum[e] - sum[s-1]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum4_11659 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");

    // sum[i] = 1번째부터 i번째까지의 누적합
    // 인덱스 0은 사용하지 않고, 1부터 시작 (1-based indexing)
    int[] sum = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      sb.append(sum[e] - sum[s - 1]).append("\n");
    }

    System.out.print(sb);
  }
}
