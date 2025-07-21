package boj.silver;

/* BOJ 11047 Silver 4 - 동전 0 */

// K원을 만드는데 필요한 동전 개수의 최솟값
// 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
// 각 동전이 다음 동전의 배수 관계이거나 작은 동전들의 조합으로 큰 동전을 만들 수 없는 구조 > 그리디 알고리즘 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0_11047 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int remaining = k;
    int cnt = 0;
    for (int i = n - 1; i >= 0; i--) {
      int share = remaining / arr[i];
      if (share > 0) {
        remaining %= arr[i];
        cnt += share;
      }
    }
    System.out.println(cnt);
  }
}
