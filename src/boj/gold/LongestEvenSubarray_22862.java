package boj.gold;

/* BOJ 22862 Gold 5 - 가장 긴 짝수 연속한 부분 수열 (large) */

// 최대 K번 원소를 삭제한 수열에서 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이
// 슬라이딩 윈도우

/*
 *  홀수가 정확히 K개인 경우의 최대 길이가 아님
 *  홀수가 최대 K개까지 포함된 윈도우에서 짝수가 가장 많은 경우
 *  → 윈도우 크기와 홀수 개수가 독립적으로 변하므로 매 단계마다 짝수 개수를 계산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestEvenSubarray_22862 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int right = 0;
    int max = 0;
    int oddCnt = 0;

    while (right < n) {
      // 새로운 원소를 윈도우에 추가
      if (arr[right] % 2 == 1) {
        oddCnt++;
      }

      // 홀수 개수가 K를 초과하면 윈도우 축소
      while (oddCnt > k) {
        if (arr[left] % 2 == 1) {
          oddCnt--;
        }
        left++;
      }

      // 현재 윈도우에서 짝수 개수 계산
      int evenCnt = (right - left + 1) - oddCnt;
      max = Math.max(max, evenCnt);
      right++;
    }
    System.out.println(max - k);
  }
}
