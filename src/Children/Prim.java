package src.Children;

import src.*;

public class Prim extends Algo {
    public Prim() {
        ChildrenDO();
    }

    static void ChildrenDO() {
        Algo.GetInput();
        Algo.NodeList.forEach(System.out::println);
        // Algo.ContinueCheck();
        // if(!Algo.isContinue){
        //     System.out.println("It's not a Continue Graph");
        //     System.exit(0);
        // }
        PrimAlgo();
    }

    private static void PrimAlgo() {
        // AlgoCodeHere
    }

    @Override
    public String toString() {
        return "Prim []";
    }
}
