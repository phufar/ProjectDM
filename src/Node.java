package src;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private List<String> PathList = new LinkedList<>();
    private String Head = null;
    private String Tail = null;
    private Node Next = null;
    private Node Before = null;
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
        String Path = TempPath;
        String word = "";
        for (int i = 0; i < Path.length(); i++) {
            if (i == 0) {
                word += Path.charAt(i);
            } else {
                if (Character.isAlphabetic(Path.charAt(i))) {
                    PathList.add(word);
                    word = "";
                    word += Path.charAt(i);
                } else {
                    word += Path.charAt(i);
                }

            }
            if (i == Path.length() - 1)
                PathList.add(word);
        }
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

    Node GetBefore() {
        return this.Before;
    }

    Node GetNext() {
        return this.Next;
    }

    String GetHead() {
        return this.Head;
    }

    String GetTrail() {
        return this.Tail;
    }

    boolean GetIsVertex() {
        return isVertex;
    }

    boolean GetIsEdge() {
        return isEdge;
    }
}
