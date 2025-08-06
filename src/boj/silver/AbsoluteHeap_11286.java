package boj.silver;

/* BOJ 11286 Silver 1 - 절댓값 힙 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteHeap_11286 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
      if (Math.abs(a) == Math.abs(b)) {
        return a - b; // 절댓값이 같으면 실제 값 기준 오름차순 정렬
      }
      return Math.abs(a) - Math.abs(b); // 절댓값 기준 오름차순 정렬
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(br.readLine());

      if (tmp == 0) {
        if (queue.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(queue.poll()).append("\n");
        }
      } else {
        queue.offer(tmp);
      }
    }

    System.out.print(sb);
  }
}
