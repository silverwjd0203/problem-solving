package boj.silver;

/* BOJ 1541 Silver 2 - 잃어버린 괄호 */

// 괄호를 적절히 쳐서 이 식의 값을 최소로 만듦
// 55+50-40+30-20 → ["55+50", "40+30", "20"]

// 전체 식을 '-' 기호로 나누기
// '-' 이후의 모든 항들은 괄호로 묶어서 한 번에 빼면 최소가 됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostParentheses_1541 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] subArr = br.readLine().split("-");

    int result = 0;

    for (int i = 0; i < subArr.length; i++) {
      int sum = 0;
      // 각 항을 '+' 기호로 나누고 모두 더함
      String[] addArr = subArr[i].split("\\+");

      for (String s : addArr) {
        sum += Integer.parseInt(s);
      }

      // 첫 항은 더하고, 나머지 항은 괄호를 묶어서 전부 빼줌
      if (i == 0) {
        result = sum;
      } else {
        result -= sum;
      }
    }
    System.out.println(result);
  }
}
