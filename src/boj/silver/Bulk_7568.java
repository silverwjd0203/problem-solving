package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* BOJ 7568 Silver 5 - 덩치 */

// 덩치 = (키, 몸무게)
// N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수

public class Bulk_7568 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Person[] people = new Person[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      people[i] = new Person(w, h);
    }

    int[] result = new int[n];
    Arrays.fill(result, 1); // 초기 등수를 모두 1로 설정
    for (int i = 0; i < n; i++) {
      Person curr = people[i];
      for (int j = 0; j < n; j++) { // 자신을 제외한 다른 사람과 비교
        if (i == j) {
          continue;
        }
        // 덩치가 더 큰 사람과 비교 시 등수가 증가
        if (curr.weight < people[j].weight && curr.height < people[j].height) {
          result[i]++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i : result) {
      sb.append(i).append("\n");
    }
    System.out.print(sb);
  }

  static class Person {
    int weight;
    int height;

    public Person(int weight, int height) {
      this.weight = weight;
      this.height = height;
    }
  }
}