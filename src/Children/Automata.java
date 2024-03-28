package src.Children;

import java.util.*;
import java.util.stream.Collectors;

import src.*;

public class Automata extends Algo {
    static Stack<Node> NodeStack = new Stack<>();

    public Automata() {
        ChildrenDO();
    }

    static void ChildrenDO() {
        Algo.GetInput();
        AutomataAlgo();
        Collections.reverse(Algo.NodeList);
        Algo.NodeList.forEach(NodeStack::push);
        NodeStack.forEach(null);
    }

    private static void AutomataAlgo() {
        // AlgoCodeHere
    }

    @Override
    public String toString() {
        return "Automata []";
    }
}
