package boj.silver;

/* BOJ 11279 Silver 2 - 최대 힙 */

// PriorityQueue : 우선순위가 높은 데이터를 먼저 꺼냄, 기본적으로 최소 힙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap_11279 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // 최대 힙
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        if (heap.isEmpty()) {
          // 힙이 비어있으면 0 출력
          sb.append(0).append("\n");
        } else {
          // 힙에서 최댓값 제거
          int max = heap.poll();
          sb.append(max).append("\n");
        }
      } else {
        heap.offer(x);
      }
    }

    System.out.print(sb);
  }
}
