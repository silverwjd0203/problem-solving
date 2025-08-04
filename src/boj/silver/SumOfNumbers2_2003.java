package boj.silver;

/* BOJ 2003 Silver 4 - 수들의 합 2 */

// i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수
// 누적합 + 브루트포스 or 누적합 + 투포인터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNumbers2_2003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] arr = new int[n + 1];
    int[] sum = new int[n + 1];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = sum[i - 1] + arr[i];
    }

    int cnt = 0;
    int s = 1;
    int e = 1;

    // s는 무조건 하나씩 증가시켜서 모든 시작 지점을 탐색
    // e는 합이 작을 경우에만 확장
    while (e <= n) {
      int tmp = sum[e] - sum[s - 1];
      if (tmp < m) {
        e++; // 합이 작으면 구간을 늘림
      } else if (tmp == m) {
        cnt++;
        s++; // 다음 구간 탐색
      } else {
        s++; // 합이 크면 구간을 줄임
      }
    }

    System.out.println(cnt);
  }
}
