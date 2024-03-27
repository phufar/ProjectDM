package src.Children;

import src.*;

public class Kruskal extends Algo {
    public Kruskal() {

    }

    static void ChildrenDO() {
        Algo.GetInput();
        Algo.ContinueCheck();
        if(!Algo.isContinue){
            System.out.println("It's not a Continue Graph");
            System.exit(0);
        }
        KruskalAlgo();
    }

    private static void KruskalAlgo() {
        // AlgoCodeHere
    }

    @Override
    public String toString() {
        return "Kruskal []";
    }
}
