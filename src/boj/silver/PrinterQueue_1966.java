package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ 1966 Silver 3 - 프린터 큐 */

// 중요도가 높은 문서가 먼저 인쇄되어야 함
// 특정 위치의 문서가 몇 번째로 인쇄되는지를 알아내는 것

public class PrinterQueue_1966 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int num = Integer.parseInt(br.readLine()); // 테스트케이스의 수

    for (int i = 0; i < num; i++) {
      // 문서 순서를 관리
      Queue<Document> queue = new ArrayDeque<>();
      // 현재 남은 문서들의 최대 중요도 체크
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int n = Integer.parseInt(st.nextToken()); // 문서 개수
      int m = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치

      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        int prior = Integer.parseInt(st.nextToken());
        queue.offer(new Document(j, prior));
        priorityQueue.offer(prior);
      }
      int order = 0;
      while (!queue.isEmpty() && !priorityQueue.isEmpty()) {
        // 현재 문서가 가장 높은 중요도를 가졌다면 인쇄
        if(priorityQueue.peek() == queue.peek().score) {
          Document doc = queue.poll();
          priorityQueue.poll();
          order++;
          if(doc.idx == m) { // 목표 문서를 찾으면
            break;
          }
        } else {
          // 중요도가 더 높은 문서가 뒤에 있으면 큐 뒤로 보내기
          queue.offer(queue.poll());
        }
      }
      sb.append(order).append("\n");
    }
    System.out.print(sb);
  }
}

class Document {
  int idx;
  int score;

  public Document(int idx, int score) {
    this.idx = idx;
    this.score = score;
  }
}