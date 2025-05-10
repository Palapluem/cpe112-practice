import java.util.*;

public class GraphL extends AdjL {
    boolean isDirected;
    boolean isWeighted;
    int numVertices;
    int numEdges;

    public GraphL(boolean isDirected, boolean isWeighted, int numVertices, int numEdges) {
        super();
        this.isDirected = isDirected;
        this.isWeighted = false;
        this.numVertices = numVertices;
        this.numEdges = numEdges;
    }

    public void addVertex(int ver) {
        if (!this.adjacencyList.containsKey(ver)) {
            this.adjacencyList.put(ver, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        addVertex(src);
        addVertex(dest);
        int actualWeight;
        if (isWeighted) {
            actualWeight = weight;
        } else {
            actualWeight = 1;
        }
        this.adjacencyList.get(src).add(new Pair<>(dest, actualWeight));
        if (!isDirected) {
            this.adjacencyList.get(dest).add(new Pair<>(src, actualWeight));
        }
    }
}