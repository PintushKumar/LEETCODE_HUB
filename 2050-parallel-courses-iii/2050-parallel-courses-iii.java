class Solution {
    public int minimumTime(int numCourses, int[][] prerequisites, int[] courseTimes) {
        // Create an adjacency list to represent the course prerequisites.
        List<List<Integer>> courseGraph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courseGraph.add(new ArrayList<>());
        }

        // Populate the adjacency list based on the given prerequisites.
        for (int i = 0; i < prerequisites.length; i++) {
            int parentCourse = prerequisites[i][0]-1; // Parent course as prerequisites.
            int childCourse = prerequisites[i][1]-1; // Child course dependent on prerequisites.
            courseGraph.get(parentCourse).add(childCourse);
        }

        // Create an array to store the in-degrees of each course.
        int inDegrees[] = new int[numCourses];

        // Calculate the in-degrees based on the prerequisites.
        for (int parentCourse = 0; parentCourse < numCourses; parentCourse++) {
            for (int childCourse : courseGraph.get(parentCourse)) {
                inDegrees[childCourse]++;
            }
        }

        // Use a queue to perform topological sorting.
        Queue<Integer> queue = new ArrayDeque<>();

        // Create an array to store the maximum time required for each course.
        int maxTimeRequired[] = new int[numCourses];

        // Initialize the queue with courses that have no prerequisites.
        for (int course = 0; course < numCourses; course++) {
            if (inDegrees[course] == 0) {
                queue.add(course);
                maxTimeRequired[course] = courseTimes[course];
            }
        }

        // Perform topological sorting and calculate the maximum time for each course.
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            for (int dependentCourse : courseGraph.get(currentCourse)) {
                inDegrees[dependentCourse]--;
                // Update the maximum time for the current course.
                maxTimeRequired[dependentCourse] = Math.max(maxTimeRequired[dependentCourse], maxTimeRequired[currentCourse] + courseTimes[dependentCourse]);
                if (inDegrees[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }

        // Find the maximum time among all courses, which represents the minimum time needed.
        int minTimeRequired = 0;
        for (int time : maxTimeRequired) {
            minTimeRequired = Math.max(minTimeRequired, time);
        }

        return minTimeRequired; // Return the minimum time needed to complete all courses.
    }
}
