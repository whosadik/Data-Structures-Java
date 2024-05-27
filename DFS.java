import java.util.*;

public class DFS {

    private static <V> List<V> dfs(V v, GraphInterface<V> g, Map<V, Boolean> used) {
        if (Boolean.TRUE.equals(used.get(v))) {
            return new ArrayList<>();
        }

        List<V> ans = new ArrayList<>();
        ans.add(v);
        used.put(v, true);

        Iterable<V> nextVs = g.getAdjacencyList(v);
        for (V nextV : nextVs) {
            List<V> nextDFSVs = dfs(nextV, g, used);
            ans.addAll(nextDFSVs);
        }

        return ans;
    }

    public static <V> List<V> dfs(GraphInterface<V> g, V startV) {
        Map<V, Boolean> used = new HashMap<>();
        return dfs(startV, g, used);
    }
}
