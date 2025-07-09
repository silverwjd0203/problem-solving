package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ 10816 Silver 4 - 숫자 카드 2 */

// 카운팅 정렬 응용
// 각 카드 번호의 개수를 미리 세어두기

public class NumberCard2_10816 {

  // 카드 번호 범위 : -10,000,000 ~ 10,000,000
  private static final int MAX = 10_000_000;
  // 카드 번호 음수인 경우 처리하기 위한 오프셋
  private static final int OFFSET = 10_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // 상근이가 가진 카드 개수

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] cntArr = new int[MAX * 2 + 1];

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      cntArr[num + OFFSET]++;
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(st.nextToken());
      sb.append(cntArr[num + OFFSET]);

      if (i != m - 1) {
        sb.append(" ");
      }
    }
    System.out.print(sb);
  }
}
