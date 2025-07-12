package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* BOJ 2839 Silver 4 - 설탕 배달 */

// 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있음, 최대한 적은 봉지
// 5kg 봉지를 최대한 많이 사용해야 봉지 개수를 최소화할 수 있음 (그리디)

public class SugarDelivery_2839 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    int cnt = 0;

    if(num % 5 == 0){
      cnt = num / 5;
      System.out.println(cnt);
      return;
    }

    // 5kg 봉지 i개를 사용하는 경우의 수를 역순으로 탐색
    // 나머지를 3kg 봉지로 채울 수 있는지 확인
    for (int i = num / 5; i >= 0; i--) {
      int rest = num - (i * 5); // 남은 무게
      if(rest % 3 == 0) {
        cnt = i + (rest / 3);
        break;
      }
    }
    // 어떤 경우도 나눠떨어지지 않으면 -1
    System.out.println(cnt == 0 ? -1 : cnt);
  }
}
