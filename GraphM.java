// Implement your code in this file
public class GraphM extends AdjM {
    boolean isDirected;
    boolean isWeighted;
    int numVertices;
    int numEdges;

    public GraphM(boolean isDirected, boolean isWeighted, int n) {
        super(n);
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        this.numVertices = n;
    }

    public void addEdge(int i, int j, int weight) {
        int actualWeight;
        if (isWeighted) {
            actualWeight = weight;
        } else {
            actualWeight = 1;
        }
        this.matrix[i][j] = weight;
        if (!isDirected) {
            this.matrix[j][i] = actualWeight;
        }
        numEdges++;
    }
}
