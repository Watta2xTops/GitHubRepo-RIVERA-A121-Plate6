import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Problem2 {

    // Method to print edges and their counts from an adjacency matrix
    public static void listEdges(int[][] adjMatrix) {
        int n = adjMatrix.length;
        Map<String, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                if (adjMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCount.put(edge, adjMatrix[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the adjacency matrix
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        // Input the adjacency matrix
        int[][] adjMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        // List the edges and their counts
        listEdges(adjMatrix);

        scanner.close();
    }
}
