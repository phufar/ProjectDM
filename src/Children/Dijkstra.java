package src.Children;

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
        System.out.println("Enter start vertex: ");
        String start = input.nextLine();
        Node startNode = NodeList.stream().filter(node -> node.GetHead().equals(start)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Dijkstra []";
    }
}
