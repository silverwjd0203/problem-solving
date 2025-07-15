package boj.silver;

/* BOJ 1436 Silver 5 - 영화감독 숌 */

// 종말의 수 = 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieDirector_1436 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int cnt = 0;

    // 완전 탐색 - 666부터 시작해서 하나씩 증가하며 확인
    for (int i = 666; ; i++) {
      String num = String.valueOf(i); // 현재 숫자를 문자열로 변환하여 "666"이 포함되어 있는지 확인
      if (num.contains("666")) {
        cnt++;
      }

      if (cnt == n) {
        System.out.println(num);
        return;
      }
    }
  }
}
