package src.Children;

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
    }

    @Override
    public String toString() {
        return "Dijkstra []";
    }
}
