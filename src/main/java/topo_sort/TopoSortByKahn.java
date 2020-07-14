package topo_sort;

import java.util.LinkedList;

public class TopoSortByKahn {

    public void kahn(Graph graph) {
        // 统计每个顶点的入度
        int[] inDegree = new int[graph.getV()];
        LinkedList<Integer>[] adj = graph.getAdj();
        for (int i = 0; i < graph.getV(); ++i) {
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < graph.getV(); ++i) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); ++j) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0)
                    queue.add(k);
            }
        }
    }

    public static void main(String[] args) {
        TopoSortByKahn topoSortByKahn = new TopoSortByKahn();
        Graph graph = new Graph(7);
        graph.addEdge(4,2);
        graph.addEdge(5,2);
        graph.addEdge(1,0);
        graph.addEdge(6,3);
        graph.addEdge(2,0);
        graph.addEdge(3,1);
        graph.addEdge(4,1);
        topoSortByKahn.kahn(graph);
    }

}
