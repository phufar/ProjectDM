package src.Children;

import java.util.ArrayList;
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
        DijkstraAlgo();
        if(!Algo.isContinue){
            System.out.println("It's not a Continue Graph");
            System.exit(0);
        }
    }

    private static void DijkstraAlgo() {
        // AlgoCodeHere
        List<List<Node>> GroupNodeList = Algo.NodeList.stream().collect(Collectors.groupingBy(node -> node.GetHead()))
                                                        .values().stream().collect(Collectors.toList());
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
        
        List<Node> visit = new ArrayList<>();
        for (int i = 0 ; i < GroupNodeList.size() ; i++) {
            Node minNode = GroupNodeList.get(i).stream().min((node1, node2) -> node1.GetLength().compareTo(node2.GetLength())).get();
            System.out.println(minNode.GetHead() + " " + minNode.GetTrail() + " " + minNode.GetLength());
            visit.add(minNode);
        }
    }

    @Override
    public String toString() {
        return "Dijkstra []";
    }
}
