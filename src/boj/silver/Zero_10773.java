package boj.silver;

/* BOJ 10773 Silver 4 - 제로 */

// 0을 외치면 가장 최근에 쓴 수를 지움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i < num; i++) {
      int m = Integer.parseInt(br.readLine());
      if(m == 0) stack.pop();
      else stack.push(m);
    }

    int sum = 0;
    while(!stack.isEmpty()) {
      sum += stack.pop();
    }

    System.out.println(sum);
  }
}
