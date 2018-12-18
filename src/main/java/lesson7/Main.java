package lesson7;

public class Main {
    final static int VERTEX_COUNT = 10;
    public static void main(String[] args) {
        System.out.println("==BreadthPath==");
        Graph graph = graphInit();
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, 0);
        System.out.println("Path to 9 = " + bfs.pathTo(9));
        System.out.println("Dist to 9 = " + bfs.distTo(9));
        System.out.println("Path to 5 = " + bfs.pathTo(5));
        System.out.println("Dist to 5 = " + bfs.distTo(5));
        System.out.println("Path to 6 = " + bfs.pathTo(6));
        System.out.println("Dist to 6 = " + bfs.distTo(6));
        System.out.println("==DijkstraPath==");
        WeightGraph graph1 = weightGraphInit();
        DijkstraPaths dp = new DijkstraPaths(graph1, 0);
        System.out.println("Path to 9 = " + dp.pathTo(9));
        System.out.println("Dist to 9 = " + dp.distTo(9));
        System.out.println("Path to 5 = " + dp.pathTo(5));
        System.out.println("Dist to 5 = " + dp.distTo(5));
        System.out.println("Path to 6 = " + dp.pathTo(6));
        System.out.println("Dist to 6 = " + dp.distTo(6));
    }

    private static Graph graphInit() {
        Graph graph = new Graph(VERTEX_COUNT);
        graph.addEdge(0, 1);
        graph.addEdge(0, 7);
        graph.addEdge(0, 3);

        graph.addEdge(1, 4);

        graph.addEdge(4, 2);
        graph.addEdge(4, 5);

        graph.addEdge(2, 5);

        graph.addEdge(5, 8);
        graph.addEdge(5, 9);

        graph.addEdge(8, 7);
        graph.addEdge(8, 9);

        graph.addEdge(7, 6);

        graph.addEdge(3, 6);

        return graph;
    }

    private static WeightGraph weightGraphInit() {
        WeightGraph graph = new WeightGraph(VERTEX_COUNT);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 7, 3);
        graph.addEdge(0, 3, 1);

        graph.addEdge(1, 4, 4);

        graph.addEdge(4, 2, 2);
        graph.addEdge(4, 5, 4);

        graph.addEdge(2, 5, 1);

        graph.addEdge(5, 8, 2);
        graph.addEdge(5, 9, 5);

        graph.addEdge(8, 7, 2);
        graph.addEdge(8, 9, 1);

        graph.addEdge(7, 6, 1);

        graph.addEdge(3, 6, 6);

        return graph;
    }
}
