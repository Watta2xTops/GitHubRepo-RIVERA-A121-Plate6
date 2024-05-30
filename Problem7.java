import java.util.*;

public class Problem7 {

    // Method to build the incidence matrix from the edge list
    public static int[][] buildIncidenceMatrix(List<int[]> edges, int n, int m) {
        int[][] incidenceMatrix = new int[n][m];
        int edgeIndex = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int count = edge[2]; // Number of times the edge appears

            // Add entries for each occurrence of the edge
            for (int i = 0; i < count; i++) {
                incidenceMatrix[u][edgeIndex] = 1;
                incidenceMatrix[v][edgeIndex] = 1;
                edgeIndex++;
            }
        }
        return incidenceMatrix;
    }

    // Method to print the incidence matrix
    public static void printIncidenceMatrix(int[][] incidenceMatrix) {
        int n = incidenceMatrix.length;
        int m = incidenceMatrix[0].length;

        System.out.println("Incidence Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example edges of a graph (vertex pairs with count of each edge)
        List<int[]> edges = Arrays.asList(
                new int[]{0, 1, 2}, // Edge (0, 1) appears twice
                new int[]{1, 2, 1}, // Edge (1, 2) appears once
                new int[]{2, 0, 1}, // Edge (2, 0) appears once
                new int[]{2, 3, 1}  // Edge (2, 3) appears once
        );

        // Determine the number of vertices (n) and edges (m)
        int n = 4; // Number of vertices
        int m = edges.stream().mapToInt(edge -> edge[2]).sum(); // Total number of edge appearances

        int[][] incidenceMatrix = buildIncidenceMatrix(edges, n, m);
        printIncidenceMatrix(incidenceMatrix);
    }
}
