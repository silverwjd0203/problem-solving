package boj.silver;

/* BOJ 9375 Silver 3 - 패션왕 신해빈 */

// 한번 입었던 옷들의 조합을 절대 다시 입지 않음
// 조합(Combination) + 경우의 수 계산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FashionKing_9375 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int test = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (test-- > 0) {
      int n = Integer.parseInt(br.readLine());
      Map<String, Integer> map = new HashMap<>();

      for (int i = 0; i < n; i++) {
        String[] input = br.readLine().split(" ");
        String type = input[1];
        map.put(type, map.getOrDefault(type, 0) + 1);
      }

      int cnt = 1;

      // 각 의상 종류별로 (의상 개수 + 1)을 곱함
      // +1은 해당 종류를 안 입는 경우를 포함
      for(int val : map.values()) {
        cnt *= (val+ 1); // 각 의상 종류별로 (입는 경우 수 + 안 입는 경우 1)을 곱함
      }

      // 아무것도 안 입는 경우(=알몸) 1가지를 뺌
      sb.append(cnt - 1).append("\n");
    }
    System.out.print(sb);
  }
}
