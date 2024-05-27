package graph;

public class Edge<V extends Vertex> {
    private final V vertex;
    private final double weight;

    public Edge(V vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public V getVertex() {
        return vertex;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{vertex=" + vertex + ", weight=" + weight + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> edge = (Edge<?>) o;

        if (Double.compare(edge.weight, weight) != 0) return false;
        return vertex.equals(edge.vertex);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = vertex.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
