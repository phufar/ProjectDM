package src.Children;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

import src.*;

public class Dijkstra extends Algo {
    private static final int INF = Integer.MAX_VALUE;
    private static ArrayList<ArrayList<DijkstraNode>> graph;

    public Dijkstra() {
        ChildrenDO();
    }

    static void ChildrenDO() {
        Algo.GetInput();
        DijkstraAlgo();
    }

    private static void convertNode() {
        List<String> tmp1 = Algo.NodeList.stream().map(node -> node.GetHead()).collect(Collectors.toList());
        List<String> tmp2 = Algo.NodeList.stream().map(node -> node.GetTail()).collect(Collectors.toList());
        Set<String> NodeSet = new HashSet<>();
        tmp1.forEach(NodeSet::add);
        tmp2.forEach(NodeSet::add);
        graph = new ArrayList<>(NodeSet.size());
        List<List<Node>> GroupNodeList = Algo.NodeList.stream().collect(Collectors.groupingBy(node -> node.GetHead()))
                                                      .values().stream().collect(Collectors.toList());
        
        int i = 0;
        for (List<Node> list : GroupNodeList) {
            graph.add(new ArrayList<>());
            for (Node node : list) {
                graph.get(i).add(new DijkstraNode(node.GetTail(), node.GetLength()));
            }
            i++;
        }
    }

    private static void DijkstraAlgo() {
        // AlgoCodeHere
        Node startNode = null;
        while (startNode == null) {
            System.out.println("Enter start vertex: ");
            String start = input.nextLine();
            System.out.println(start);
            startNode = NodeList.stream().filter(node -> node.GetHead().equals(start))
                                .findFirst().orElse(null);
            if (startNode == null) {
                System.out.println("Vertex not found, try again");
            }
        }
        convertNode();
        calculate(graph, startNode.GetHead());
    }

    private static void calculate(ArrayList<ArrayList<DijkstraNode>> graph, String start) {
        int numVertices = graph.size();
        int[] distances = new int[numVertices];
        Arrays.fill(distances, INF);
        distances[intValueVertex(start)] = 0;

        PriorityQueue<DijkstraNode> minHeap = new PriorityQueue<>();
        minHeap.offer(new DijkstraNode(start, 0));

        while (!minHeap.isEmpty()) {
            DijkstraNode currentNode = minHeap.poll();
            int currentId = intValueVertex(currentNode.id);
            int currentDistance = currentNode.distance;

            if (currentDistance > distances[currentId])
                continue;

            for (DijkstraNode neighbor : graph.get(currentId)) {
                int newDistance = currentDistance + neighbor.distance;
                if (newDistance < distances[intValueVertex(neighbor.id)]) {
                    distances[intValueVertex(neighbor.id)] = newDistance;
                    minHeap.offer(new DijkstraNode(neighbor.id, newDistance));
                }
            }
        }
        printSolution(distances);
    }

    private static void printSolution(int[] distances) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    private static int intValueVertex(String vertex) {
        return Integer.parseInt(vertex.substring(1));
    }

    @Override
    public String toString() {
        return "Dijkstra []";
    }
}

class DijkstraNode implements Comparable<DijkstraNode> {
    String id;
    int distance;

    DijkstraNode(String id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(DijkstraNode other) {
        return Integer.compare(this.distance, other.distance);
    }
}