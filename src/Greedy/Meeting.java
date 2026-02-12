package Greedy;

import java.util.Arrays;

class Meet {
    int start;
    int end;

    Meet(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "("+this.start+","+this.end+")";
    }
}

public class Meeting {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeetings(start, end));
    }

    public static int  maxMeetings(int[] start, int[] end) {
        if (start.length == 0) return 0;

        Meet[] meetings = new Meet[start.length];
        for(int i = 0; i < start.length; i++) {
            meetings[i] = new Meet(start[i], end[i]);
        }

        Arrays.sort(meetings, (a, b) -> a.end - b.end);
        System.out.print(Arrays.toString(meetings));

        // select first meeting becoz start time of first meeting may be -ve
        int count = 1;
        int lastEnd = meetings[0].end;

        for(int i = 1; i < meetings.length; i++) {
            if(lastEnd <= meetings[i].start) {
                count++;
                lastEnd = meetings[i].end;
            }
        }

        return count;
    }
}
