import java.util.*;

public class Problem5 {

    // Method to build the adjacency list from the edge list
    public static Map<Integer, List<Integer>> buildGraph(List<int[]> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }

    // BFS method to check if the graph is bipartite
    public static boolean isBipartite(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> colorMap = new HashMap<>();
        for (int startNode : graph.keySet()) {
            if (!colorMap.containsKey(startNode)) {
                // Start BFS from this node
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(startNode);
                colorMap.put(startNode, 0);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int currentColor = colorMap.get(node);

                    for (int neighbor : graph.get(node)) {
                        if (!colorMap.containsKey(neighbor)) {
                            colorMap.put(neighbor, 1 - currentColor); // Assign opposite color
                            queue.offer(neighbor);
                        } else if (colorMap.get(neighbor) == currentColor) {
                            return false; // Same color on both adjacent nodes, not bipartite
                        }
                    }
                }
            }
        }
        return true;
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
            Map<Integer, List<Integer>> graph = buildGraph(edges);
            if (isBipartite(graph)) {
                System.out.println("The graph is bipartite.");
            } else {
                System.out.println("The graph is not bipartite.");
            }
        } else {
            System.out.println("Invalid input: The graph must be simple (no self-loops or multiple edges).");
        }

        scanner.close();
    }
}
