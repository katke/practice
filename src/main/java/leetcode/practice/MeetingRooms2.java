package leetcode.practice;

import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2 {
  String source = "https://leetcode.com/problems/meeting-rooms-ii/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
  * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
  * return the minimum number of conference rooms required.
  * */

  int solution(int[][] intervals) {
    if (intervals == null) return 0;
    else if (intervals.length < 2) return intervals.length;
    List<Meeting> meetingTimes = new ArrayList<>();
    for (int[] interval : intervals) {
      meetingTimes.add(new Meeting(interval[0], interval[1]));
    }
    meetingTimes.sort(Comparator.comparingInt(meetingA -> meetingA.start));
    List<Room> conferenceRooms = new ArrayList<>();
    for (Meeting nextMeeting : meetingTimes) {
      var availableConfRoom = conferenceRooms
          .stream()
          .filter(room -> room.freeAsOf <= nextMeeting.start)
          .findFirst();
      if (availableConfRoom.isEmpty()) {
        conferenceRooms.add(new Room(nextMeeting));
      } else {
        availableConfRoom.get().scheduleMeeting(nextMeeting);
      }
    }
    return conferenceRooms.size();
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
