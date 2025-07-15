package boj.silver;

/* BOJ 2164 Silver 4 - 카드2 */

// 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태
// 카드 한 장 남을 때까지 반복
// 제일 위에 있는 카드를 바닥에 버린 후 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Card2_2164 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // 양쪽 끝에서 삽입과 삭제가 모두 가능한 덱 사용
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      deque.offer(i);
    }
    while (deque.size() > 1) {
      deque.pollFirst(); // 제일 위 카드 제거
      deque.offerLast(deque.pollFirst()); // 그 다음 카드 맨 뒤로 이동
    }
    System.out.println(deque.pollFirst());
  }
}
