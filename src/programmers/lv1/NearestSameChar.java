package programmers.lv1;

/* Programmers Lv.1 - 가장 가까운 글자 */

// 문자열에서 각 문자의 가장 가까운 이전 위치와의 거리 구하기

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NearestSameChar {

  public static void main(String[] args) {
    int[] result1 = mySolution("banana");
    int[] result2 = otherSolution("foobar");

    System.out.println(Arrays.toString(result1));
    System.out.println(Arrays.toString(result2));
  }

  /* 각 문자마다 왼쪽으로 거슬러 올라가며 처음 같은 문자가 나타날 때까지 탐색 (비효율적) */
  public static int[] mySolution(String s) {
    int[] answer = new int[s.length()];
    Arrays.fill(answer, -1);

    for (int i = s.length() - 1; i >= 0; i--) {
      for(int j = i - 1; j >= 0; j--) {
        if(s.charAt(i) == s.charAt(j)) {
          answer[i] = i - j;
          break;
        }
      }
    }
    return answer;
  }

  /* 각 문자의 마지막 등장 위치를 저장하고, 등장할 때마다 거리 계산 */
  public static int[] otherSolution(String s) {
    int[] answer = new int[s.length()];
    Map<Character, Integer> map = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(map.containsKey(c)) {
        answer[i] = i - map.get(c);
      } else { // 처음 나온 문자인 경우
        answer[i] = -1;
      }
      map.put(c, i); // value : 마지막 등장 인덱스
    }
    return answer;
  }
}
