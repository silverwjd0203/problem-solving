package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ 1676 Silver 5 - 팩토리얼 0의 개수 */

// N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수 구하기
// 0을 만들기 위해서는 2와 5의 쌍이 필요

public class FactorialTrailingZeros_1676 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

//    solveMyWay(num);
    solveOtherWay(num);
  }

  /* 모든 수를 반복하며 각 수에서 2와 5의 인수가 몇 개인지 따로 세어줌 (비효율적) */
  private static void solveMyWay(int num) {
    int[] arr = new int[2];
    for (int i = num; i > 0; i--) {
      int tmp = i;
      // 2의 개수 구하기
      while (tmp / 2 != 0) {
        if (tmp % 2 != 0) {
          break;
        }
        arr[0]++;
        tmp /= 2;
      }
      // 5의 개수 구하기
      while (tmp / 5 != 0) {
        if (tmp % 5 != 0) {
          break;
        }
        arr[1]++;
        tmp /= 5;
      }
    }
    // 0의 개수 >> 2 × 5의 쌍의 개수
    int cnt = Math.min(arr[0], arr[1]);
    System.out.print(cnt);
  }

  /* 팩토리얼에서 2가 항상 5보다 더 많이 나오므로, 5의 개수만 세면 됨 */
  private static void solveOtherWay(int num) {
    int cnt = 0;
    // 단순히 5의 배수만 세면 25, 125, ... 에서 5가 1개만 있다고 잘못 계산
    // 5의 배수, 25의 배수, 125의 배수... 개수 세기
    // ex : 125 = 5³ → 5가 3개 → 첫 번째는 ⌊n/5⌋, 두 번째는 ⌊n/25⌋, 세 번째는 ⌊n/125⌋에서
    // 5의 개수 = ⌊n/5⌋ + ⌊n/5^2⌋ + ⌊n/5^3⌋ + ⌊n/5^4⌋ + ...
    for (int i = 5; i <= num; i *= 5) {
      cnt += num / i;
    }
    System.out.print(cnt);
  }
}
