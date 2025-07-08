package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* BOJ 10828 Silver 4 - 스택 */

// 정수를 저장하는 스택
// First In First Out

public class Stack_10828 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < num; i++) {
      String[] cmd = br.readLine().split(" ");
      switch (cmd[0]) {
        case "push":
          stack.push(Integer.parseInt(cmd[1]));
          break;

        case "pop":
          sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
          break;

        case "size":
          sb.append(stack.size()).append('\n');
          break;

        case "top":
          sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
          break;

        case "empty":
          sb.append(stack.isEmpty() ? 1 : 0).append('\n');
          break;

        default:
          break;
      }
    }
    System.out.print(sb);
  }
}
