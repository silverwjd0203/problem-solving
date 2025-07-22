package boj.silver;

/* BOJ 11399 Silver 4 - ATM */

// 각 사람이 기다리는 시간을 최소화하려면, 인출 시간이 짧은 사람부터 먼저 처리
// 앞서 처리되는 사람의 시간은 뒤의 모든 사람들의 대기시간에 영향을 주기 때문
// 시간이 짧은 사람을 앞에 세울수록 전체 대기시간의 합이 줄어듦

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Atm_11399 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 오름차순 정렬
    Arrays.sort(arr);

    int sum = 0;
    int tmp = 0;
    for(int i = 0; i < n; i++) {
      tmp += arr[i]; // 지금까지의 대기시간 + 현재 사람의 인출시간
      sum += tmp;
    }

    System.out.println(sum);
  }
}
