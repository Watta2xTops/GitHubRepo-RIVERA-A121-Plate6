import java.util.*;

public class Problem6 {

    // Method to build the adjacency matrix from the edge list
    public static int[][] buildAdjMatrix(List<int[]> edges, int n) {
        int[][] adjMatrix = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Ensure no multiple edges in an undirected graph by setting value to 1
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1; // For undirected graph
        }
        return adjMatrix;
    }

    // Method to print the adjacency matrix
    public static void printAdjMatrix(int[][] adjMatrix) {
        int n = adjMatrix.length;
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numberOfEdges = scanner.nextInt();
        List<int[]> edges = new ArrayList<>();

        System.out.println("Enter the edges (format: vertex1 vertex2):");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            if (vertex1 != vertex2) { // Ensure no self-loops
                edges.add(new int[]{vertex1, vertex2});
            }
        }

        int[][] adjMatrix = buildAdjMatrix(edges, n);
        printAdjMatrix(adjMatrix);

        scanner.close();
    }
}
