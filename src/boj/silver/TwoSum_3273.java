package boj.silver;

/* BOJ 3273 Silver 3 - 두 수의 합 */

// 자연수 x가 주어졌을 때, arr[i] + arr[j] = x를 만족하는 (i, j)쌍의 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSum_3273 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr); // 오름차순 정렬 (개수만 세면 되므로 인덱스 무관)

    int x = Integer.parseInt(br.readLine());

    int s = 0;
    int e = n - 1;
    int cnt = 0;

    while (s < e) {
      int sum = arr[s] + arr[e];
      if (sum == x) {
        s++; // 다음 쌍을 찾기 위해 시작 포인터를 오른쪽으로 이동
        cnt++;
      } else if (sum < x) {
        s++; // 합을 증가시키기 위해 시작 포인터를 오른쪽으로 이동
      } else {
        e--; // 합을 감소시키기 위해 끝 포인터를 왼쪽으로 이동
      }
    }

    System.out.println(cnt);
  }
}
