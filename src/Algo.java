package src;

import java.util.*;
import src.Children.*;

public class Algo {
    protected static Integer InputLength;
    protected static String Input;
    protected static List<Integer> LengthList;
    protected static List<String> InputList = new ArrayList<>();
    private static TYPE AlgoType = TYPE.DEFAULT;
    private static Algo USE;
    protected static Boolean isContinue = false;
    static Scanner input = new Scanner(System.in);

    public Algo() {

    }

    public static void Start() {
        Algo.SELECTTYPE();
        Algo.USETYPE(AlgoType);
        System.out.println(USE);
        USE.ChildrenDO();
    }

    // Select
    private static void SELECTTYPE() {
        List<Integer> Choice = Arrays.asList(1, 2, 3, 4);
        System.out.print(
                "Input Type of Your Choice \n1.PRIM Algorithm\n2.KRUSKAL Algorithm\n3.DIJKSTRA Algorithm\n4.AUTOMATA\n:");
        Integer InputChoice = 0;
        while (!Choice.contains(InputChoice)) {
            InputChoice = input.nextInt();
            System.out.println(":");
            if (!Choice.contains(InputChoice)) {
                System.out.println("Try Again");
            }
        }
        switch (InputChoice) {
            case 1:
                Algo.AlgoType = TYPE.PRIM;
                break;
            case 2:
                Algo.AlgoType = TYPE.KRUSKAL;
                break;
            case 3:
                Algo.AlgoType = TYPE.DIJKSTRA;
                break;
            case 4:
                Algo.AlgoType = TYPE.AUTOMATA;
                break;
            default:
                System.exit(0);
                // status exit 0, 1, -1
                break;
        }
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

    // Do Children

    // Get Input
    protected static void GetInput() {
        String Line = Algo.AlgoType == TYPE.AUTOMATA ? "Enter Each Number" : "Enter Each Path";
        String TempInput;
        Integer TempLength;
        int count = 0;
        System.out.print("Enter Length:");
        Algo.InputLength = input.nextInt();
        System.out.println(Line);
        while (count < InputLength) {
            System.out.println(String.format("Enter the %d", count));
            TempInput = input.nextLine();
            InputList.add(TempInput);
            if(!(Algo.AlgoType==TYPE.AUTOMATA)){
                System.out.println(String.format("Enter the Length of %d :",TempInput));
                TempLength = input.nextInt();
                LengthList.add(TempLength);
            }
            count++;
        }
    }
    protected static void ContinueCheck(){
    }

}
