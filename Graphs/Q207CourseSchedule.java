package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are 
given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course 
bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/

public class Q207CourseSchedule {
    
    public boolean canFinish(int V, int[][] prerequisites) {
        
        // create a graph/adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // find indegree of each course
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // add all nodes to queue with indegree = 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<Integer>();
        // o(v + e)
        while (!queue.isEmpty()) 
        {
            int node = queue.peek();
            queue.remove();
            topo.add(node);
            // node is in your topo sort so we'll remove it from the indegree
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    queue.add(it);
            }
        }
        if (topo.size() == V)
            return true;
        return false;
    }
}