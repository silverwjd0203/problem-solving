package boj.silver;

/* BOJ 1929 Silver 3 - 소수 구하기 */

// 소수 =  1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindPrimeNumbers_1929 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

//    for (int i = m; i <= n; i++) {
//      if (isPrime(i)) {
//        sb.append(i).append("\n");
//      }
//    }

    boolean[] result = getPrimePrimeNums(n);
    for (int i = m; i <= n; i++) {
      if (result[i]) {
        sb.append(i).append("\n");
      }
    }

    System.out.print(sb);
  }

  private static boolean isPrime(int num) {
    if (num <= 1) { // 1은 소수가 아님
      return false;
    }

    // 2부터 √num까지 나누어 떨어지는 수가 있는지 확인
    // √num 넘는 약수가 있다면 반드시 그보다 작은 약수도 존재 > √num까지만 확인해도 충분함
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  /* 에라토스테네스의 체 - 특정 숫자 이하의 모든 소수를 구함 */
  // 소수의 배수는 소수가 아니다
  // 어떤 수가 소수라면 그 수의 배수들은 모두 소수가 아님을 활용
  private static boolean[] getPrimePrimeNums(int num) {
    boolean[] isPrime = new boolean[num + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (isPrime[i]) {
        // i×(i-1)은 이미 앞서 지워졌음 ex) 5×2=10 → 이미 2에 의해 지워짐
        // i의 배수들을 순서대로 지움
        for (int j = i * i; j <= num; j += i) {
          isPrime[j] = false; // i의 배수는 소수 아님
        }
      }
    }
    return isPrime;
  }
}
