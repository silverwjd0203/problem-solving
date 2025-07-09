package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/* BOJ 10814 Silver 5 - 나이순 정렬 */

// 나이가 증가하는 순, 나이가 같으면 먼저 가입한 사람이 앞에 오도록 정렬
// 입력은 가입한 순서로 주어짐

/* 카운팅 정렬 (Counting Sort) */
// 정렬할 값들이 정수이고 범위가 작을 때, 배열 인덱스를 이용해 개수를 세어 정렬

/* 안정 정렬 (Stable Sort) */
// 같은 값을 가진 항목들의 상대적인 순서가 정렬 후에도 유지 (중복된 값은 입력 순서와 동일하게 정렬)

public class AgeSort_10814 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
//    solveMyWay(br, num);
    solveOtherWay(br, num);
  }

  private static void solveMyWay(BufferedReader br, int num) throws IOException {
    List<Person> list = new ArrayList<>();

    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
    }
    list.sort(Comparator.comparingInt(a -> a.age)); // 나이 오름차순

    StringBuilder sb = new StringBuilder();
    for (Person p : list) {
      sb.append(p.toString()).append("\n");
    }
    System.out.print(sb);
  }

  private static void solveOtherWay(BufferedReader br, int num) throws IOException {
    StringBuilder[] bucket = new StringBuilder[201];
    for (int i = 1; i <= 200; i++) {
      bucket[i] = new StringBuilder();
    }
    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      // 같은 나이의 경우 버킷에 순서대로 쌓이므로 안정 정렬 성립
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      bucket[age].append(age).append(" ").append(name).append('\n');
    }
    for (int i = 1; i <= 200; i++) {
      System.out.print(bucket[i]);
    }
  }
}

class Person {

  int age;
  String name;

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  @Override
  public String toString() {
    return age + " " + name;
  }
}
