package com.coursera.ada1.week3;

/**
 * Created by sunilpatil on 11/19/16.
 */
public class Edge {
    int source;
    int target;

    public Edge(int source, int target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (source == edge.source) {
            if (target == edge.target)
                return true;
        } else if (source == edge.target) {
            if (target == edge.source)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + target;
        return result;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", target=" + target +
                '}';
    }
}
