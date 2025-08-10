package boj.gold;

/* BOJ 1715 Gold 4 - 카드 정렬하기 */

// 매 단계에서 가장 작은 두 묶음을 합치는 것이 전체 횟수의 최솟값을 보장
// 우선순위 큐 + 그리디

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSorting_1715 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Long> queue = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      long tmp = Long.parseLong(br.readLine());
      queue.offer(tmp);
    }

    // 카드 묶음이 하나뿐이면 합칠 필요가 없음
    if (n == 1) {
      System.out.println(0);
      return;
    }

    long sum = 0;

    // 항상 가장 작은 두 묶음을 합침
    while (queue.size() > 1) {
      long a = queue.poll();
      long b = queue.poll();

      sum += a + b;
      queue.offer(a + b);
    }

    System.out.println(sum);
  }
}
