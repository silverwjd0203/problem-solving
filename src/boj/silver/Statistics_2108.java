package boj.silver;

/* BOJ 2108 Silver 2 - 통계학 */

// 산술평균, 중앙값, 최빈값, 범위(최댓값과 최솟값의 차이)
// 주어지는 정수의 절댓값은 4,000을 넘지 않음
// 최빈값의 경우 여러 개 있을 때에는 두 번째로 작은 값을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Statistics_2108 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] freq = new int[8001];

    int sum = 0;
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      arr[i] = num;
      sum += num;
      freq[num + 4000]++;
    }

    StringBuilder sb = new StringBuilder();

    // 평균
    int avg = (int) Math.round((double) sum / n);

    Arrays.sort(arr);
    // 범위
    int range = arr[n - 1] - arr[0];
    // 중앙값
    int median = arr[(n - 1) / 2];

    // 최빈값
    int mode = 0;
    int maxFreq = Integer.MIN_VALUE; // 최대 빈도수

    for (int i : freq) {
      if (i > maxFreq) {
        maxFreq = i;
      }
    }

    int tmp = 0;
    for (int i = 0; i < 8001; i++) {
      if (freq[i] == maxFreq) {
        mode = i - 4000;
        tmp++;
        // 최빈값이 여러개인 경우 두 번째로 작은 최빈값 구하기 위해
        if (tmp == 2) {
          break;
        }
      }
    }

    sb.append(avg).append("\n")
        .append(median).append("\n")
        .append(mode).append("\n")
        .append(range);

    System.out.print(sb);
  }
}
