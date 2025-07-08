package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* BOJ 9012 Silver 4 - 괄호 */

// 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열 = VPS
// 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS
// x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS

public class Parentheses_9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < num; i++) {
      Stack<Character> stack = new Stack<>();
      String s = br.readLine();

      boolean isValid = true;
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        if (c == '(') {
          stack.push(c);
        } else { // ')'인 경우
          if (stack.isEmpty()) {
            isValid = false; // 닫는 괄호가 많아짐 > VPS 아님
            break;
          } else {
            stack.pop();
          }
        }
      }
      if (!stack.isEmpty()) isValid = false; // 여는 괄호가 남아있음 > VPS 아님
      sb.append(isValid ? "YES" : "NO").append('\n');
    }
    System.out.print(sb);
  }
}
