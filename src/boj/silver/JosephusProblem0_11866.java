package boj.silver;

/* BOJ 11866 Silver 4 - 요세푸스 문제 0 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class JosephusProblem0_11866 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    solveOtherWay(n, k);
  }

  /* ArrayList 사용한 풀이 - 인덱스 기반 */
  private static void solveMyWay(int n, int k) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");
    int idx = 0;
    // idx 0에서 시작, K=3이므로 (0+3-1) % 7 = 2 → 3 제거 >> [1, 2, 4, 5, 6, 7]
    // idx 2에서 시작, K=3이므로 (2+3-1) % 6 = 4 → 6 제거 >> [1, 2, 4, 5, 7]
    // idx 4에서 시작, K=3이므로 (4+3-1) % 5 = 1 → 2 제거 >> [1, 4, 5, 7]
    // ...
    while (!list.isEmpty()) {
      int num = list.remove((idx + k - 1) % list.size());
      sb.append(num);
      idx += k - 1; // 제거 후 다음 시작점 위치 계산 주의

      if (!list.isEmpty()) {
        sb.append(", ");
      }
    }
    sb.append(">");
    System.out.print(sb);
  }

  /* Queue 사용한 풀이 */
  private static void solveOtherWay(int n, int k) {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");

    while (!queue.isEmpty()) {
      // 앞에서 뽑아서 뒤로 보내기
      for (int i = 0; i < k - 1; i++) {
        queue.offer(queue.poll());
      }
      // k번째 사람 제거
      sb.append(queue.poll());
      if(!queue.isEmpty()) {
        sb.append(", ");
      }
    }

    sb.append(">");
    System.out.print(sb);
  }
}
