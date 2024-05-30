import java.util.*;

public class Problem3 {

    // Method to build the adjacency list from the edge list
    public static Map<Integer, List<Integer>> buildGraph(int[][] edges, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (u >= 0 && u < n && v >= 0 && v < n) {
                graph.get(u).add(v);
                graph.get(v).add(u);
            } else {
                throw new IllegalArgumentException("Invalid edge: " + u + " " + v);
            }
        }
        return graph;
    }

    // Method to check if the graph is a cycle
    public static boolean isCycleGraph(int[][] edges, int n) {
        Map<Integer, List<Integer>> graph = buildGraph(edges, n);
        Set<Integer> visited = new HashSet<>();

        // Check for cycles in all components of the graph
        for (int node = 0; node < n; node++) {
            if (!visited.contains(node)) {
                if (hasCycle(node, -1, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS method to detect cycle in an undirected graph
    private static boolean hasCycle(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                if (hasCycle(neighbor, node, graph, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();
        int[][] edges = new int[numberOfEdges][2];

        System.out.println("Enter the edges (format: vertex1 vertex2):");
        for (int i = 0; i < numberOfEdges; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        int n = edges.length; // Number of vertices

        try {
            if (isCycleGraph(edges, n)) {
                System.out.println("The graph is a cycle.");
            } else {
                System.out.println("The graph is not a cycle.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
