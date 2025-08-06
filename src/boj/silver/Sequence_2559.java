package boj.silver;

/* BOJ 2559 Silver 3 - 수열 */

// 슬라이딩 윈도우 (배열이나 문자열에서 연속된 부분 구간을 효율적으로 처리)
// 연속된 K개의 온도의 합 중 최댓값을 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence_2559 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken()); // 고정 크기의 윈도우

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int sum = 0;
    int start = 0;
    int end = k - 1;

    for (int i = start; i <= end; i++) {
      sum += arr[i];
    }

    int max = sum;
    // 윈도우를 오른쪽으로 한 칸씩 이동하며 최댓값 갱신
    for (int i = k; i < n; i++) {
      sum = sum + arr[i] - arr[i - k];
      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}
