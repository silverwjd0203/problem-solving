package boj.silver;

/* BOJ 30804 Silver 2 - 과일 탕후루 */

// 과일을 두 종류 이하로 사용한 탕후루 중에서, 과일의 개수가 가장 많아야 함
// 조건을 만족하는 가장 긴 부분 배열
// 슬라이딩 윈도우

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FruitTangHulu_30804 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Map<Integer, Integer> map = new HashMap<>();
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      arr[i] = tmp;
    }

    int left = 0;
    int right = 0;
    int max = 0; // 최대 윈도우 크기

    while (right < n) {
      map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

      // 과일 두 종류가 넘어가면 왼쪽 포인터 이동시켜 조건에 만족할 때까지 윈도우 축소
      while (map.size() > 2) {
        if (map.get(arr[left]) > 1) {
          // 해당 과일이 여러 개 있으면 개수만 감소
          map.put(arr[left], map.get(arr[left]) - 1);
        } else {
          // 해당 과일이 1개뿐이면 제거 (과일 종류 수 감소)
          map.remove(arr[left]);
        }
        left++;
      }

      max = Math.max(max, right - left + 1);
      // 다음 위치 탐색을 위해 오른쪽 포인터 이동
      right++;
    }

    System.out.println(max);
  }
}
