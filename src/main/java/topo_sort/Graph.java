package topo_sort;

import java.util.LinkedList;

public class Graph {
    // 顶点的个数
    private int v;
    // 领接表
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;++i){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s,int t){
        adj[s].add(t);
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }
}
