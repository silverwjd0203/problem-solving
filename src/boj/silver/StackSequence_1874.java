package boj.silver;

/* BOJ 1874 Silver 2 - 스택 수열 */

// 스택에 넣는 순서는 반드시 오름차순을 지켜야 함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence_1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    int idx = 1; // 다음에 넣어야 할 숫자 (1부터 시작)
    boolean isPossible = true;

    for (int i = 1; i <= n; i++) {
      int num = Integer.parseInt(br.readLine());

      // 현재 숫자까지 오름차순으로 push
      while (idx <= num) {
        stack.push(idx++);
        sb.append("+\n");
      }

      if (!stack.isEmpty() && stack.peek() == num) {
        stack.pop();
        sb.append("-\n");
      } else { // 수열 만드는 것이 불가능
        isPossible = false;
        break;
      }
    }
    System.out.print(isPossible ? sb : "NO");
  }
}
