package boj.silver;

/* BOJ 1764 Silver 4 - 듣보잡 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Nobody_1764 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    // 듣도 못한 사람의 수
    int n = Integer.parseInt(st.nextToken());
    // 보도 못한 사람의 수
    int m = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n + m; i++) {
      String name = br.readLine();
      map.put(name, map.getOrDefault(name, 0) + 1); // 각 이름의 등장 횟수
    }

    // 듣도 보도 못한 사람 = 듣도 못한 사람과 보도 못한 사람의 교집합
    List<String> list = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        list.add(entry.getKey());
      }
    }

    // 사전순으로 정렬
    Collections.sort(list);

    StringBuilder sb = new StringBuilder();
    sb.append(list.size()).append("\n");
    for(String name : list) {
      sb.append(name).append("\n");
    }

    System.out.print(sb);
  }
}
