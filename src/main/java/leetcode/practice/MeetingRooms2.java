package leetcode.practice;

import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms2 {
  String source = "https://leetcode.com/problems/meeting-rooms-ii/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N log(N))";
  String spaceComplexity = "O(N)";
  /*
  * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
  * return the minimum number of conference rooms required.
  * */

  int solution(int[][] intervals) {
    if (intervals == null) return 0;
    else if (intervals.length < 2) return intervals.length;
    List<Meeting> meetingTimes = new ArrayList<>();
    PriorityQueue<Room> confRoomsMinHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.freeAsOf));
    for (int[] interval : intervals) {
      meetingTimes.add(new Meeting(interval[0], interval[1]));
    }
    meetingTimes.sort(Comparator.comparingInt(meetingA -> meetingA.start));
    for (Meeting nextMeeting : meetingTimes) {
      var existingConfRoomAvail = confRoomsMinHeap.peek() != null
          && confRoomsMinHeap.peek().freeAsOf <= nextMeeting.start;
      if (!existingConfRoomAvail) {
        confRoomsMinHeap.add(new Room(nextMeeting));
      } else {
        var availRoom = confRoomsMinHeap.poll();
        availRoom.scheduleMeeting(nextMeeting);
        confRoomsMinHeap.add(availRoom);
      }
    }
    return confRoomsMinHeap.size();
  }

  static class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
      this.end = end;
      this.start = start;
    }
  }

  static class Room {
    int freeAsOf;

    Room(Meeting scheduledMeeting) {
      this.freeAsOf = scheduledMeeting.end;
    }

    void scheduleMeeting(Meeting scheduledMeeting) {
      this.freeAsOf = scheduledMeeting.end;
    }
  }
}
