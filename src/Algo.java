package src;

import java.util.*;
import src.Children.*;

public class Algo {
    protected static Integer InputLength;
    protected static String Input;
    protected static List<Integer> LengthList = new ArrayList<>();
    protected static List<String> InputList = new LinkedList<>();
    protected static List<Node> NodeList = new LinkedList<>();
    private static TYPE AlgoType = TYPE.DEFAULT;
    private static Algo USE;
    protected static Boolean isContinue = true;
    static Scanner input = new Scanner(System.in);

    public Algo() {

    }

    public static void Start() {
        Algo.SELECTTYPE();
        Algo.USETYPE(AlgoType);
        Algo.NodeList.forEach(System.out::println);
        // System.out.println(USE);
        // Algo.GetInput();
    }

    // Select
    private static void SELECTTYPE() {
        List<Integer> Choice = Arrays.asList(1, 2, 3, 4);
        List<TYPE> alTYPE = Arrays.asList(TYPE.PRIM, TYPE.KRUSKAL, TYPE.DIJKSTRA, TYPE.AUTOMATA);
        Integer InputChoice = 0;
        System.out.print(
<<<<<<< HEAD
                "Input Type of Your Choice \n1.PRIM Algorithm\n2.KRUSKAL Algorithm\n3.DIJKSTRA Algorithm\n4.AUTOMATA\n:");
=======
                "Input Type of Your Choice \n1.PRIM Algorithm\n2.KRUSKAL Algorithm\n3.DIJKSTRA Algorithm\n4.AUTOMATA\n: ");
        Integer InputChoice = 0;
>>>>>>> 49d0b914b56b09111a37207aa0b2ae6e80e3b0c1
        while (!Choice.contains(InputChoice)) {
            InputChoice = input.nextInt();
            if (!Choice.contains(InputChoice)) {
                System.out.println("Try Again");
<<<<<<< HEAD
                System.out.println(":");
=======
                System.out.println(": ");
>>>>>>> 49d0b914b56b09111a37207aa0b2ae6e80e3b0c1
            }
        }
        Algo.AlgoType = alTYPE.get(Choice.indexOf(InputChoice));
        System.out.println(InputChoice);
        System.out.println(Algo.AlgoType);
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
    private static void ChildrenDO() {
    }

    // Get Input
    protected static void GetInput() {
        String Line = Algo.AlgoType == TYPE.AUTOMATA ? "Enter Each Number" : "Enter Each Path";
        String TempInput;
        Integer TempLength;
        int count = 0;
        System.out.print("Enter Length:");
        Algo.InputLength = input.nextInt();
        TempInput = input.nextLine();
        System.out.println(Line);
        while (count < InputLength) {
            System.out.println(String.format("Enter the %d", count));
            TempInput = input.nextLine();
            InputList.add(TempInput);
            if (!(Algo.AlgoType == TYPE.AUTOMATA)) {
                System.out.println(String.format("Enter the Length of %s :", TempInput));
                TempLength = input.nextInt();
                input.nextLine();
                LengthList.add(TempLength);
            }
            count++;
        }
    }

    // Continue Graph Check Part
    protected static void ContinueCheck() {
        for (String Path : InputList) {
            if (Path.trim().length() <= 2) {
                isContinue = false;
                return;
            }
            Node Curr = new Node(Path);
            Curr.SetLength(LengthList.get(InputList.indexOf(Path)));
            NodeList.add(Curr);
            if (Curr.GetIsEdge() || Curr.GetIsVertex()) {
                isContinue = false;
                return;
            }

        }
        for (int i = 0; i < NodeList.size(); i++) {
            for (int j = 0; j < NodeList.size(); j++) {
                if (NodeList.get(i).GetTrail().equals(NodeList.get(j).GetHead())) {
                    NodeList.get(i).SetNext(NodeList.get(j));
                }
                if (NodeList.get(i).GetHead().equals(NodeList.get(j).GetTrail())) {
                    NodeList.get(i).SetBefore(NodeList.get(j));
                }
            }
        }
        int countStart = 0;
        int countEnd = 0;
        int countCircle = 0;
        for (Node Path : NodeList) {
            if (!Path.IsHasBefore())
                countStart++;
            if (!Path.IsHasNext())
                countEnd++;
        }
        for (int i = 0; i < NodeList.size(); i++) {
            for (int j = 0; j < NodeList.size(); j++) {
                if (NodeList.get(i).GetHead().equals(NodeList.get(j).GetHead())
                        && (!NodeList.get(i).equals(NodeList.get(j)))) {
                    countCircle++;
                }
                if (NodeList.get(i).GetTrail().equals(NodeList.get(j).GetTrail())
                        && (!NodeList.get(i).equals(NodeList.get(j)))) {
                    countCircle++;
                }
            }
        }
        if ((countEnd > 1 || countStart > 1) && countCircle > 1) {
            isContinue = false;
        }

    }

}
