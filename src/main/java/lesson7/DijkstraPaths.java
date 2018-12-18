package lesson7;

import java.util.Arrays;
import java.util.LinkedList;

public class DijkstraPaths {

    private int[] vertexWeights;
    private boolean[] marked;
    private int[] edgeTo;
    private int source;
    private static final int INF = Integer.MAX_VALUE;

    public DijkstraPaths(WeightGraph graph, int source) {
        if (source < 0 || source > graph.vertexCount())
            throw new IllegalArgumentException("Номер вершины должен быть от 0 до количества вершин");
        this.source = source;
        vertexWeights = new int[graph.vertexCount()];
        marked = new boolean[graph.vertexCount()];
        edgeTo = new int[graph.vertexCount()];
        Arrays.fill(vertexWeights, INF);
        Arrays.fill(marked, false);
        vertexWeights[source] = 0;
        dfs(graph);
    }

    private void dfs(WeightGraph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            int  vertex = queue.removeFirst();
            LinkedList<Integer> weights = graph.weightList(vertex);
            int iterator = 0;
            for (int w:graph.adjList(vertex)) {
                int weight = weights.get(iterator++);
                if (!marked[w]) {
                    int newCost = vertexWeights[vertex] + weight;
                    if (newCost < vertexWeights[w]) {
                        vertexWeights[w] = newCost;
                        edgeTo[w] = vertex;
                    }
                    queue.addLast(w);
                }
            }
            marked[vertex] = true;
        }
    }

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    public int distTo(int dist) {
        return vertexWeights[dist];
    }
}
