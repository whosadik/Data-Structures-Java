import java.util.*;

public class BFS {

    public static <V> List<V> bfs(GraphInterface<V> g, V startV) {
        if (!g.hasVertex(startV)) {
            return new ArrayList<>();
        }

        int n = g.getVerticesCount();
        List<V> walkQueue = new ArrayList<>(n);

        Map<V, Boolean> used = new HashMap<>();
        Map<V, Boolean> stack = new HashMap<>();
        Map<V, Boolean> nextStack = new HashMap<>();
        stack.put(startV, true);
        nextStack = new HashMap<>();

        while (!stack.isEmpty()) {
            for (V v : stack.keySet()) {
                used.put(v, true);
            }

            for (V v : stack.keySet()) {
                walkQueue.add(v);
                Iterable<V> nextVs = g.getAdjacencyList(v);
                for (V nextV : nextVs) {
                    if (Boolean.TRUE.equals(used.get(nextV))) {
                        continue;
                    }
                    nextStack.put(nextV, true);
                }
            }

            stack = nextStack;
            nextStack = new HashMap<>();
        }

        return walkQueue;
    }
}
