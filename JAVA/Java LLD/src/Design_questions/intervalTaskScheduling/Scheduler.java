package Design_questions.intervalTaskScheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scheduler {
    // Finds the last non-overlapping task index using binary search
    private int findLastNonOverlapping(List<Task> tasks, int currentIndex) {
        int low = 0, high = currentIndex - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (tasks.get(mid).endTime <= tasks.get(currentIndex).startTime) {
                if (mid == currentIndex - 1 || tasks.get(mid + 1).endTime > tasks.get(currentIndex).startTime) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // No non-overlapping task found
    }

    public List<Task> getMaxPrioritySchedule(List<Task> tasks) {
        // Sort tasks by end time
        tasks.sort(Comparator.comparingInt(task -> task.endTime));

        int n = tasks.size();
        int[] dp = new int[n];
        int[] previous = new int[n]; // To reconstruct the schedule

        dp[0] = tasks.get(0).priority;
        previous[0] = -1;

        for (int i = 1; i < n; i++) {
            // Option 1: Exclude the current task
            int exclude = dp[i - 1];

            // Option 2: Include the current task
            int include = tasks.get(i).priority;
            int lastNonOverlapping = findLastNonOverlapping(tasks, i);
            if (lastNonOverlapping != -1) {
                include += dp[lastNonOverlapping];
            }

            // Take the maximum of include and exclude
            dp[i] = Math.max(include, exclude);

            // Update previous index
            previous[i] = (dp[i] == include) ? lastNonOverlapping : i - 1;
        }

        // Reconstruct the optimal schedule
        List<Task> result = new ArrayList<>();
        for (int i = n - 1; i >= 0; ) {
            if (previous[i] == i - 1) {
                i--;
            } else {
                result.add(tasks.get(i));
                i = previous[i];
            }
        }

        Collections.reverse(result);
        return result;
    }
}