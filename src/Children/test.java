package src.Children;
import java.util.*;

public class test {
    public test(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        List<List<Edge>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();
        System.out.println("Enter the edges (source destination weight): ");
        for (int i = 0; i < E; i++) {
            int source = scanner.nextInt() - 1; // Decrement vertex index
            int destination = scanner.nextInt() - 1; // Decrement vertex index
            int weight = scanner.nextInt();
            graph.get(source).add(new Edge(destination, weight));
            graph.get(destination).add(new Edge(source, weight)); // For undirected graph
        }

        List<Edge> mst = primMST(graph);
        System.out.println("Minimum Spanning Tree:");
        mst.forEach(edge -> System.out.println("Edge: " + (edge.destination + 1) + " Weight: " + edge.weight)); // Increment vertex index
        
        scanner.close();
    }

    static class Edge {
        int destination, weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static List<Edge> primMST(List<List<Edge>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(0, 0));
        List<Edge> mst = new ArrayList<>();

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.destination;
            if (visited[u]) continue;

            visited[u] = true;
            mst.add(edge);

            graph.get(u).stream()
                    .filter(e -> !visited[e.destination])
                    .forEach(pq::offer);
        }
        return mst;
    }

    public static void main(String[] args) {

    }
}
