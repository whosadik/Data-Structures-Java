import java.util.*;

public class DIJKSTRA {

    public static class HeapNode<V> implements Comparable<HeapNode<V>> {
        V vertex;
        double priority;

        public HeapNode(V vertex, double priority) {
            this.vertex = vertex;
            this.priority = priority;
        }

        @Override
        public int compareTo(HeapNode<V> o) {
            return Double.compare(this.priority, o.priority);
        }
    }

    private static <V> Map<V, Double> initDistances(WeightedGraph<V> g, V start) {
        Map<V, Double> distances = new HashMap<>();
        List<V> keys = BFS.bfs(g, start);

        for (V key : keys) {
            distances.put(key, Double.MAX_VALUE);
        }

        distances.put(start, 0.0);
        return distances;
    }

    public static <V> Map<V, Double> dijkstra(WeightedGraph<V> g, V startV) {
        Map<V, Double> distances = initDistances(g, startV);

        PriorityQueue<HeapNode<V>> pq = new PriorityQueue<>();
        pq.add(new HeapNode<>(startV, 0.0));

        while (!pq.isEmpty()) {
            HeapNode<V> minNode = pq.poll();
            V iterableV = minNode.vertex;

            List<WeightedGraph.Edge<V>> checkedNextNodes = g.getAdjacencyList(iterableV);
            for (WeightedGraph.Edge<V> nextEdge : checkedNextNodes) {
                V updatedV = nextEdge.getVertex();
                double nextDest = distances.get(iterableV) + nextEdge.getWeight();

                if (nextDest < distances.get(updatedV)) {
                    distances.put(updatedV, nextDest);
                    pq.add(new HeapNode<>(updatedV, nextDest));
                }
            }
        }

        return distances;
    }
}
