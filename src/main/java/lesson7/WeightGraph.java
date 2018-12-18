package lesson7;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class WeightGraph extends Graph {

    private LinkedList<Integer>[] weightLists;
    //private LinkedHashMap<Integer, Integer>[] weightList;

    public WeightGraph(int vertexCount) {
        super(vertexCount);
        weightLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            weightLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        addEdge(v1, v2);
        if (weight < 0) {
            throw new IllegalArgumentException("Вес ребра не может быть отрицательным");
        }
        weightLists[v1].add(weight);
        weightLists[v2].add(weight);
    }

    public LinkedList<Integer> weightList(int vertex) {
        return weightLists[vertex];
    }
}
