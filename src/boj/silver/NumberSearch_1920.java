package boj.silver;

/* BOJ 1920 Silver 4 - 수 찾기 */

// 모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NumberSearch_1920 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());
    int[] targets = new int[m];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      targets[i] = Integer.parseInt(st.nextToken());
    }

    solveMyWay(arr, targets);
//    solveOtherWay(arr, targets);
  }

  /* 개수를 저장할 필요가 없고 존재 여부만 확인하므로 HashMap 대신 HashSet 사용 */
  private static void solveMyWay(int[] arr, int[] targets) {
    Set<Integer> set = new HashSet<>();
    for (int n : arr) {
      set.add(n);
    }
    StringBuilder sb = new StringBuilder();
    for (int t : targets) {
      sb.append(set.contains(t) ? "1\n" : "0\n");
    }
    System.out.print(sb);
  }

  /* 이진 탐색 - 정렬된 배열(또는 리스트)에서 탐색 범위를 반씩 줄여가며 원하는 값을 빠르게 찾음 */
  private static void solveOtherWay(int[] arr, int[] targets) {
    // 이진 탐색을 위한 정렬
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    for (int t : targets) {
      sb.append(binarySearch(arr, t) ? "1\n" : "0\n");
    }
    System.out.print(sb);
  }

  private static boolean binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) { // 현재 탐색 구간이 유효한지 확인
      // 중간값 계산
      int mid = (left + right) / 2;
      if (arr[mid] == target) {
        return true;
      }
      if (arr[mid] < target) { // 오른쪽 탐색
        left = mid + 1;
      } else { // 왼쪽 탐색
        right = mid - 1;
      }
    }
    return false;
  }

}
