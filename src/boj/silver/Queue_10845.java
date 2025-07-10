package boj.silver;

/* BOJ 10845 Silver 4 - 큐 */

// 정수를 저장하는 큐
// First In First Out

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Queue_10845 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
//    solveMyWay(br, num);
    solveOtherWay(br, num);
  }

  /* ArrayList 사용하여 큐를 구현 > remove(0)의 경우 인덱스 0 제거 시 모든 요소를 앞으로 이동시켜야 하므로 비효율적 */
  private static void solveMyWay(BufferedReader br, int num) throws IOException {
    List<Integer> queue = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String op = st.nextToken();

      switch (op) {
        case "push":
          queue.add(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          sb.append(queue.isEmpty() ? -1 : queue.remove(0)).append('\n');
          break;
        case "size":
          sb.append(queue.size()).append('\n');
          break;
        case "empty":
          sb.append(queue.isEmpty() ? 1 : 0).append('\n');
          break;
        case "front": // 가장 먼저 들어온 요소
          sb.append(queue.isEmpty() ? -1 : queue.get(0)).append('\n');
          break;
        case "back": // 가장 나중에 들어온 요소
          sb.append(queue.isEmpty() ? -1 : queue.get(queue.size() - 1)).append('\n');
          break;
      }
    }
    System.out.print(sb);
  }

  /* ArrayDeque 사용 > 큐 연산을 위해 최적화된 자료구조 */
  private static void solveOtherWay(BufferedReader br, int num) throws IOException {
    Deque<Integer> queue = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String op = st.nextToken();

      switch (op) {
        case "push":
          queue.offer(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
          break;
        case "size":
          sb.append(queue.size()).append('\n');
          break;
        case "empty":
          sb.append(queue.isEmpty() ? 1 : 0).append('\n');
          break;
        case "front":
          sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
          break;
        case "back":
          sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
          break;
      }
    }

    System.out.print(sb);
  }
}

// ArrayList 메서드 removeFirst, removeLast, getFirst, getLast >> Java 21 이상에서 가능