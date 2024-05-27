package algo;

import java.util.*;

public class GraphHeap<V> extends PriorityQueue<GraphHeap.HeapNode<V>> {

    public static class HeapNode<V> {
        V vertex;
        double priority;

        public HeapNode(V vertex, double priority) {
            this.vertex = vertex;
            this.priority = priority;
        }

        public V getVertex() {
            return vertex;
        }

        public double getPriority() {
            return priority;
        }
    }

    @Override
    public boolean add(HeapNode<V> node) {
        return super.add(node);
    }

    @Override
    public HeapNode<V> poll() {
        return super.poll();
    }

    @Override
    public HeapNode<V> peek() {
        return super.peek();
    }

    public void update(HeapNode<V> node, double newPriority) {
        // Remove and re-insert the node to update its priority.
        this.remove(node);
        node.priority = newPriority;
        this.add(node);
    }

    public static void main(String[] args) {
        // Example usage
        GraphHeap<String> heap = new GraphHeap<>();

        heap.add(new HeapNode<>("A", 5.0));
        heap.add(new HeapNode<>("B", 3.0));
        heap.add(new HeapNode<>("C", 7.0));

        System.out.println("Top element: " + heap.poll().getVertex()); // B
        heap.update(new HeapNode<>("A", 5.0), 2.0);
        System.out.println("Top element after update: " + heap.poll().getVertex()); // A
    }
}
