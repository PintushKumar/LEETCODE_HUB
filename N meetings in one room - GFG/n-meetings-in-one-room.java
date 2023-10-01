//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting {
    int startTime;
    int endTime;

    Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int startTimes[], int endTimes[], int n) {
        // Create a list of meetings with start and end times.
        ArrayList<Meeting> meetings = new ArrayList<>();

        // Fill the list with the given start and end times.
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(startTimes[i], endTimes[i]));
        }

        // Sort the list of meetings based on their end times in ascending order.
        Collections.sort(meetings, (a, b) -> a.endTime - b.endTime);

        int meetingCount = 0; // Initialize a counter for scheduled meetings.
        int previousEndTime = Integer.MIN_VALUE; // Initialize with the end time of the first meeting.

        // Iterate through the sorted list of meetings.
        for (int i = 0; i < n; i++) {
            int currentStartTime = meetings.get(i).startTime; // Get the start time of the current meeting.
            int currentEndTime = meetings.get(i).endTime; // Get the end time of the current meeting.

            // Check if the current meeting can be accommodated in the room based on its start and end times.
            if (previousEndTime < currentStartTime) {
                meetingCount++; // Increment the counter as a meeting can be scheduled.
                previousEndTime = currentEndTime; // Update the previous end time with the end time of the current meeting.
            } else {
                previousEndTime = Math.min(previousEndTime, currentEndTime); // Update the previous end time to the minimum of the two end times.
            }
        }

        return meetingCount; // Return the total count of scheduled meetings.
    }
}

