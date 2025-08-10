package boj.gold;

/* BOJ 1931 Gold 5 - 회의실 배정 */

// 종료 시간이 빠른 회의를 우선 선택해야 최대 회의 개수 보장
// 그리디

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MeetingRoomAssignment_1931 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Meeting> queue = new PriorityQueue<>((a, b) -> {
      // 종료 시간이 같다면 시작 시간이 빠른 순
      if(a.end == b.end) {
        // [(7,7), (5,7), (8,9)] : (7,7) 선택 → 5 < 7이므로 (5,7)은 겹쳐서 불가능
        // [(5,7), (7,7), (8,9)] : (5,7) 선택 → 7 >= 7이므로 (7,7) 선택
        return a.start - b.start;
      }
      // 종료 시간 빠른 순
      return a.end - b.end;
    });

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      queue.add(new Meeting(s, e));
    }

    int cnt = 1;
    Meeting now = queue.poll();

    while (!queue.isEmpty()) {
      Meeting next = queue.poll();
      // 시간이 겹치지 않으면 회의 선택
      if (next.start >= now.end) {
        // 새로 선택된 회의로 업데이트
        now = next;
        cnt++;
      }
    }
    System.out.println(cnt);
  }

  static class Meeting {

    int start;
    int end;

    public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
