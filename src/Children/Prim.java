package src.Children;

import src.*;

public class Prim extends Algo {
    public Prim() {

    }

    static void ChildrenDO() {
        Algo.GetInput();
        Algo.ContinueCheck();
        if(!Algo.isContinue){
            System.out.println("It's not a Continue Graph");
            System.exit(0);
        }
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
