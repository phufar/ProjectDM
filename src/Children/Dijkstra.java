package src.Children;

import java.util.List;
import java.util.stream.Collectors;

import src.*;

public class Dijkstra extends Algo {
    public Dijkstra() {
        ChildrenDO();
    }

    static void ChildrenDO() {
        Algo.GetInput();
        Algo.ContinueCheck();
        if(!Algo.isContinue){
            System.out.println("It's not a Continue Graph");
            System.exit(0);
        }
        DijkstraAlgo();
    }

    private static void DijkstraAlgo() {
        // AlgoCodeHere
        List<List<Node>> GroupNodeList = Algo.NodeList.stream().collect(Collectors.groupingBy(node -> node.GetHead()))
                                                        .values().stream().collect(Collectors.toList());
        Node startNode = null;
        while (startNode == null) {
            System.out.println("Enter start vertex: ");
            String start = input.nextLine();
            startNode = NodeList.stream().filter(node -> node.GetHead().equals(start))
                                .findFirst().orElse(null);
            if (startNode == null) {
                System.out.println("Vertex not found, try again");
            }
        }
        
        for (List<Node> nodeList : GroupNodeList) {
            Node minNode = nodeList.stream().min((node1, node2) -> node1.GetLength().compareTo(node2.GetLength())).get();
            
        }
    }

    @Override
    public String toString() {
        return "Dijkstra []";
    }
}
