package src;

import java.util.*;
import src.Children.*;

public class Algo {
    protected static Integer InputLength;
    protected static String Input;
    protected static List<Node> NodeList = new LinkedList<>();
    private static TYPE AlgoType = TYPE.DEFAULT;
    private static Algo USE;
    protected static Scanner input = new Scanner(System.in);
    protected static String AutomataLine;

    public Algo() {

    }

    public static void Start() {
        Algo.SELECTTYPE();
        Algo.USETYPE(AlgoType);
    }

    // Select
    private static void SELECTTYPE() {
        List<Integer> Choice = Arrays.asList(1, 2, 3, 4);
        List<TYPE> alTYPE = Arrays.asList(TYPE.PRIM, TYPE.KRUSKAL, TYPE.DIJKSTRA, TYPE.AUTOMATA);
        Integer InputChoice = 0;
        System.out.print(
                "Input Type of Your Choice \n1.PRIM Algorithm\n2.KRUSKAL Algorithm\n3.DIJKSTRA Algorithm\n4.AUTOMATA\n:");
        while (!Choice.contains(InputChoice)) {
            InputChoice = input.nextInt();
            if (!Choice.contains(InputChoice)) {
                System.out.println("Try Again");
                System.out.println(": ");
            }
        }
        Algo.AlgoType = alTYPE.get(Choice.indexOf(InputChoice));
    }

    // Use Selected
    private static void USETYPE(TYPE T) {
        switch (Algo.AlgoType) {
            case PRIM:
                Algo.USE = new Prim();
                break;

            case KRUSKAL:
                Algo.USE = new Kruskal();
                break;

            case DIJKSTRA:
                Algo.USE = new Dijkstra();
                break;

            case AUTOMATA:
                Algo.USE = new Automata();
                break;

        }
    }

    // Implement for Children Class
    private static void ChildrenDO() {}

    // Get Input
    protected static void GetInput() {
        String Line = Algo.AlgoType == TYPE.AUTOMATA ? "Enter Each Number" : "Enter Each Path";
        String TempInput;
        Integer TempLength;
        int count = 0;
        input.nextLine();
        if (AlgoType != TYPE.AUTOMATA) {
            System.out.print("Enter Length:");
            Algo.InputLength = input.nextInt();
            TempInput = input.nextLine();
            System.out.println(Line);
            while (count < InputLength) {
                System.out.println(String.format("Enter the %d", count));
                TempInput = input.nextLine();
                System.out.println(String.format("Enter the Length of %s :", TempInput));
                TempLength = input.nextInt();
                input.nextLine();
                Node curr = new Node(TempInput);
                curr.SetLength(TempLength);
                NodeList.add(curr);
                count++;
            }
        }else{
            System.out.println("Enter the Automata Input");
            AutomataLine = input.nextLine();
        }
    }

    protected static TYPE getAlgoType() {
        return Algo.AlgoType;
    }

}
