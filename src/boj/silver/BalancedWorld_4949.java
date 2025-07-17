package boj.silver;

/* BOJ 4949 Silver 4 - 균형 잡힌 세상 */

// 문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")
// 괄호들이 올바르게 짝지어졌는지 판단

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld_4949 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      String str = br.readLine();
      // 입력의 종료 조건
      if (str.charAt(0) == '.') {
        break;
      }

      Stack<Character> stack = new Stack<>();
      boolean isBalanced = true;
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == '(' || c == '[') {
          stack.push(c);
        } else if (c == ')') {
          if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
          } else {
            isBalanced = false;
            break;
          }
        } else if (c == ']') {
          if (!stack.isEmpty() && stack.peek() == '[') {
            stack.pop();
          } else {
            isBalanced = false;
            break;
          }
        }
        // 다른 문자들('.', 알파벳, 공백 등)은 무시
      }

      // 순회 후 스택이 비어있지 않으면 균형이 맞지 않음
      if (!stack.isEmpty()) {
        isBalanced = false;
      }
      sb.append(isBalanced ? "yes" : "no").append("\n");
    }
    System.out.print(sb);
  }
}
