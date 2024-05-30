import java.util.*;
public class Problem4 {

    // Method to build the degree map from the edge list
    public static Map<Integer, Integer> calculateDegrees(List<int[]> edges) {
        Map<Integer, Integer> degreeMap = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Increment the degree for both vertices in the undirected graph
            degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);
            degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
        }
        return degreeMap;
    }

    // Method to print the degree of each vertex
    public static void printDegrees(Map<Integer, Integer> degreeMap) {
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " has a degree of " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of edges: " );
        int numberOfEdges = scanner.nextInt();
        List<int[]> edges = new ArrayList<>();

        System.out.println("Enter the edges (format: vertex1 vertex2):");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges.add(new int[]{vertex1, vertex2});
        }

        Map<Integer, Integer> degreeMap = calculateDegrees(edges);
        printDegrees(degreeMap);

        scanner.close();
    }
}

