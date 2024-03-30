package src.Children;

import src.*;

public class Prim extends Algo {
    public Prim() {
        ChildrenDO();
    }

    static void ChildrenDO() {
        PrimAlgo();
    }

    private static void PrimAlgo() {
        new PrimII();
    }

    @Override
    public String toString() {
        return "Prim []";
    }
}
