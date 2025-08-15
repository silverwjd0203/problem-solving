package boj.gold;

/* BOJ 1074 Gold 5 - Z */

// 분할정복
// 목표 좌표 (r, c)가 어느 사분면에 있는지 판단하여 해당 사분면만 탐색해야함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {

  static int r, c, cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    int num = (int) Math.pow(2, n);

    recursive(0, 0, num);
    System.out.println(cnt);
  }

  private static void recursive(int startX, int startY, int num) {
    if (num == 1) return;

    int half = num / 2;
    int area = half * half; // 각 사분면의 크기

    // 좌표 (r, c)가 어느 사분면에 있는지 확인하여 해당 사분면만 탐색
    if (r < startX + half && c < startY + half) {
      // 1사분면 (왼쪽 위)
      recursive(startX, startY, half);
    } else if (r < startX + half && c >= startY + half) {
      // 2사분면 (오른쪽 위)
      cnt += area; // 0사분면 패스
      recursive(startX, startY + half, half);
    } else if (r >= startX + half && c < startY + half) {
      // 3사분면 (왼쪽 아래)
      cnt += 2 * area; // 0,1사분면 패스
      recursive(startX + half, startY, half);
    } else {
      // 4사분면 (오른쪽 아래)
      cnt += 3 * area; // 0,1,2사분면 패스
      recursive(startX + half, startY + half, half);
    }
  }
}