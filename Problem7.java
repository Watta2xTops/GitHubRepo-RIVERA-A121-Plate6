import java.util.*;

public class Problem7 {

    // Method to build the incidence matrix from the edge list
    public static int[][] buildIncidenceMatrix(List<int[]> edges, int numVertices, int numEdges) {
        int[][] incidenceMatrix = new int[numVertices][numEdges];
        int edgeIndex = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int count = edge[2];

            // Set the incidence matrix values for each occurrence of the edge
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
        System.out.println("Incidence Matrix:");
        for (int[] row : incidenceMatrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        List<int[]> edges = new ArrayList<>();

        System.out.println("Enter the edges with their counts (format: vertex1 vertex2 count):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int count = scanner.nextInt();
            edges.add(new int[]{vertex1, vertex2, count});
        }

        int[][] incidenceMatrix = buildIncidenceMatrix(edges, numVertices, numEdges);
        printIncidenceMatrix(incidenceMatrix);

        scanner.close();
    }
}
