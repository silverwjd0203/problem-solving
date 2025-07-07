package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* BOJ 1181 Silver 5 - 단어 정렬  */

// 길이가 짧은 것부터
// 길이가 같으면 사전 순으로
// 중복된 단어는 하나만 남기고 제거

public class WordSort_1181 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    solveOtherWay2(br, num);
  }

  /* 나의 풀이 - 중복 제거	시 contains 사용하여 매번 선형 탐색하여 비효율적 */
  private static void solveMyWay(BufferedReader br, int num) throws IOException {
    List<String> list = new ArrayList<>();

    for (int i = 0; i < num; i++) {
      String str = br.readLine();
      if (!list.contains(str)) {
        list.add(str);
      }
    }
    list.sort(getComparator());

    StringBuilder sb = new StringBuilder();
    for (String s : list) {
      sb.append(s).append("\n");
    }
    System.out.print(sb);
  }

  /* 다른 풀이 - HashSet(중복제거) + 정렬 */
  private static void solveOtherWay1(BufferedReader br, int num) throws IOException {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < num; i++) {
      set.add(br.readLine());
    }
    List<String> list = new ArrayList<>(set);
    list.sort(getComparator());

    StringBuilder sb = new StringBuilder();
    for (String s : list) {
      sb.append(s).append("\n");
    }
    System.out.print(sb);
  }

  /* 다른 풀이 - 배열 + 정렬 후 중복 제거 > 가장 효율적 */
  private static void solveOtherWay2(BufferedReader br, int num) throws IOException {
    String[] arr = new String[num];
    for (int i = 0; i < num; i++) {
      arr[i] = br.readLine();
    }

    Arrays.sort(arr, getComparator());

    StringBuilder sb = new StringBuilder();
    String prev = "";  // 이전 단어

    // 정렬된 상태에서 중복 제거
    for (String s : arr) {
      if (!s.equals(prev)) {
        sb.append(s).append("\n");
        prev = s;
      }
    }
    System.out.print(sb);
  }

  // 정렬 기준
  private static Comparator<String> getComparator() {
    return (a, b) -> {
      if (a.length() != b.length()) {
        return a.length() - b.length(); // 길이 오름차순
      }
      return a.compareTo(b); // 사전순
    };
  }
}
