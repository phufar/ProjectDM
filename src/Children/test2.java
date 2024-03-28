package src.Children;

import java.util.*;

public class test2 {
    public test2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            System.out.println("Enter source, destination, and weight for edge " + (i + 1) + ": ");
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(source, destination, weight));
        }

        List<Edge> mst = kruskalMST(edges, V);

        System.out.println("Minimum Spanning Tree:");
        mst.forEach(edge -> System.out
                .println("Edge: " + edge.source + " - " + edge.destination + " Weight: " + edge.weight));

        scanner.close();
    }

    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public static List<Edge> kruskalMST(List<Edge> edges, int vertices) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        UnionFind uf = new UnionFind(vertices);
        List<Edge> mst = new ArrayList<>();

        edges.stream()
                .filter(e -> uf.find(e.source) != uf.find(e.destination))
                .peek(e -> uf.union(e.source, e.destination))
                .forEach(mst::add);

        return mst;
    }
}
