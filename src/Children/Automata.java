package src.Children;

import java.util.*;

import src.*;

public class Automata extends Algo {
    static String AutomataLine;
    static AutomataState State = AutomataState.START;

    public Automata() {
        ChildrenDO();
    }

    static void ChildrenDO() {
        Algo.GetInput();
        AutomataLine = Algo.AutomataLine;
        AutomataAlgo();
    }

    private static void AutomataAlgo() {
        // AlgoCodeHere
        for (int i = 0; i < AutomataLine.length(); i++) {
            Character currChar = AutomataLine.charAt(i);
            switch (State) {
                case START:
                    if (currChar == '1') {
                        State = AutomataState.START;
                    }
                    if (currChar == '0') {
                        State = AutomataState.STATE_1;
                    }
                    break;
                case STATE_1:
                    if (currChar == '0') {
                        State = AutomataState.STATE_1;
                    }
                    if (currChar == '1') {
                        State = AutomataState.ACCEPT;
                    }
                    break;
                case ACCEPT:
                    if (currChar == '1') {
                        State = AutomataState.START;
                    }
                    if (currChar == '0') {
                        State = AutomataState.STATE_1;
                    }
                    break;
                case REJECT: {break;}
            }
        }
        if (State == AutomataState.ACCEPT) {
            System.out.println("Accepted!");
        } else {
            System.out.println("Rejected!");
        }
        System.out.println("And It's always accept input that end with 01!");
    }

    @Override
    public String toString() {
        return "Automata []";
    }
}
