package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Node {
    private List<String> PathList = new LinkedList<>();
    private String Head = null;
    private String Tail = null;
    private Node Next = null;
    private Node Before = null;
    private Integer Length = Integer.MAX_VALUE;
    private boolean hasNext = false;
    private boolean hasBefore = false;
    private boolean isVertex = false;
    private boolean isEdge = false;

    Node(String TempPath) {
        ToList(TempPath);
        Head = PathList.get(0);
        Tail = PathList.get(PathList.size() - 1);
        SetIsVertex();
        SetIsEdge();
    }

    void ToList(String TempPath) {
        PathList = Arrays.asList(TempPath.split(" "));
    }

    void SetLength(Integer Length) {
        this.Length = Length;
    }

    void SetIsVertex() {
        if (this.Head == this.Tail && this.PathList.size() <= 3 && this.Head.startsWith("v")) {
            this.isVertex = true;
        }
    }

    void SetIsEdge() {
        if (this.Head == this.Tail && this.PathList.size() <= 3 && this.Head.startsWith("e")) {
            this.isEdge = true;
        }
    }

    void SetNext(Node N) {
        this.Next = N;
        this.hasNext = true;
    }

    void SetBefore(Node N) {
        this.Before = N;
        this.hasBefore = true;
    }

    boolean IsHasBefore() {
        return this.hasBefore;
    }

    boolean IsHasNext() {
        return this.hasNext;
    }

    public Node GetBefore() {
        return this.Before;
    }

    public Node GetNext() {
        return this.Next;
    }

    public String GetHead() {
        return this.Head;
    }

    public String GetTail() {
        return this.Tail;
    }

    public boolean GetIsVertex() {
        return isVertex;
    }

    public boolean GetIsEdge() {
        return isEdge;
    }
    public Integer GetLength(){
        return this.Length;
    }

    @Override
    public String toString() {
        return Algo.getAlgoType()==TYPE.AUTOMATA ? String.format("Node Current %s", this.GetHead())
        : String.format("Node Head: %s Tail: %s Weigth: %d", this.GetHead(), this.GetTail(),this.GetLength());
    }
}
