package boj.silver;

/* BOJ 11650 Silver 5 - 좌표 정렬하기 */

// x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoordinateSort_11650 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Coordinate[] arr = new Coordinate[n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      arr[i] = new Coordinate(x, y);
    }

    Arrays.sort(arr, (a, b) -> {
      if (a.x == b.x) {
        return a.y - b.y;
      }
      return a.x - b.x;
    });

    StringBuilder sb = new StringBuilder();
    for(Coordinate c : arr) {
      sb.append(c.x).append(" ").append(c.y).append("\n");
    }

    System.out.print(sb);
  }


  static class Coordinate {

    int x;
    int y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
