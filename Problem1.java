import java.util.*;

public class Problem1 {

    // Builds the adjacency list from the edge list
    public static Map<Integer, List<Integer>> buildGraph(List<int[]> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }

    // Depth First Search method
    public static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    // Method to determine if the graph is connected and find the number of connected components
    public static void checkConnectivity(List<int[]> edges) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        Set<Integer> visited = new HashSet<>();

        if (graph.isEmpty()) {
            System.out.println("The graph is empty.");
            return;
        }

        // Start DFS from the first node (if the graph is not empty)
        int startNode = graph.keySet().iterator().next();
        dfs(startNode, graph, visited);

        // Check if all nodes were visited
        if (visited.size() == graph.size()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            // Find all connected components
            int numComponents = 0;
            visited.clear();
            for (int node : graph.keySet()) {
                if (!visited.contains(node)) {
                    dfs(node, graph, visited);
                    numComponents++;
                }
            }
            System.out.println("Number of connected components: " + numComponents);
        }
    }

    // Method to check if the graph is simple
    public static boolean isSimpleGraph(List<int[]> edges) {
        Set<String> edgeSet = new HashSet<>();
        for (int[] edge : edges) {
            if (edge[0] == edge[1]) {
                return false; // self-loop
            }
            String edgeString = edge[0] < edge[1] ? edge[0] + "-" + edge[1] : edge[1] + "-" + edge[0];
            if (!edgeSet.add(edgeString)) {
                return false; // multiple edge
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();
        List<int[]> edges = new ArrayList<>();

        System.out.println("Enter the edges (format: vertex1 vertex2):");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges.add(new int[]{vertex1, vertex2});
        }

        if (isSimpleGraph(edges)) {
            checkConnectivity(edges);
        } else {
            System.out.println("Invalid input: The graph must be simple (no self-loops or multiple edges).");
        }

        scanner.close();
    }
}
