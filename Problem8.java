import java.util.Arrays;

public class Problem8 {

    // Method to check if two graphs are isomorphic
    public static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;
        if (graph2.length != n) {
            return false;
        }

        // Array to store the mapping from vertices of graph1 to vertices of graph2
        int[] mapping = new int[n];
        Arrays.fill(mapping, -1);

        // Array to check if a vertex in graph2 is already mapped
        boolean[] used = new boolean[n];

        return isIsomorphicUtil(graph1, graph2, mapping, used, 0);
    }

    // Utility method to check isomorphism using backtracking
    private static boolean isIsomorphicUtil(int[][] graph1, int[][] graph2, int[] mapping, boolean[] used, int vertex) {
        int n = graph1.length;
        if (vertex == n) {
            return true; // All vertices are mapped
        }

        for (int i = 0; i < n; i++) {
            if (!used[i] && isValidMapping(graph1, graph2, mapping, vertex, i)) {
                mapping[vertex] = i;
                used[i] = true;

                if (isIsomorphicUtil(graph1, graph2, mapping, used, vertex + 1)) {
                    return true;
                }

                mapping[vertex] = -1;
                used[i] = false;
            }
        }
        return false;
    }

    // Method to check if mapping vertex1 -> vertex2 is valid
    private static boolean isValidMapping(int[][] graph1, int[][] graph2, int[] mapping, int vertex1, int vertex2) {
        for (int i = 0; i < vertex1; i++) {
            if (graph1[vertex1][i] != graph2[vertex2][mapping[i]]) {
                return false;
            }
            if (graph1[i][vertex1] != graph2[mapping[i]][vertex2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example graphs represented as adjacency matrices
        int[][] graph1 = {
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 0, 1, 0}
        };

        int[][] graph2 = {
                {0, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 1, 1, 0}
        };

        if (areIsomorphic(graph1, graph2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }
}
