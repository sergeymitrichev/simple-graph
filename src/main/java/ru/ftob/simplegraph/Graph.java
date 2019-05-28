package ru.ftob.simplegraph;

import java.util.*;

public class Graph<T> {

  private Boolean directed;

  private Map<Vertex<T>, List<Vertex<T>>> vertices = new HashMap<>();

  public Graph() {
    this(false);
  }

  public Graph(Boolean directed) {
    this.directed = directed;
  }

  public void addVertex(T type) {
    vertices.putIfAbsent(new Vertex<>(type), new ArrayList<>());
  }

  public void addEdge(T from, T to) {
    Vertex<T> v1 = new Vertex<>(from);
    Vertex<T> v2 = new Vertex<>(to);
    try {
      vertices.get(v1).add(v2);
      if (!directed) {
        vertices.get(v2).add(v1);
      }
    } catch (NullPointerException e) {
      throw new IllegalArgumentException(
          String.format("Edge vertices (%s, %s) must be part of the graph", from, to)
      );
    }

  }

  public List<Edge<T>> getPath(T from, T to) {
    Vertex<T> v1 = new Vertex<>(from);
    Vertex<T> v2 = new Vertex<>(to);
    if (vertices.containsKey(v1) && vertices.containsKey(v2)) {
      ArrayList<Edge<T>> edges = new ArrayList<>();
      getPathByBreadthFirstSearch(v1, v2).stream().reduce((f, t) -> {
        edges.add(new Edge<>(f, t));
        return t;
      });
      return edges;
    }
    throw new IllegalArgumentException(
        String.format("Path vertices (%s, %s) must be part of the graph", from, to));
  }

  private List<Vertex<T>> getPathByBreadthFirstSearch(Vertex<T> from, Vertex<T> to) {

    if (from.equals(to) || vertices.get(from).contains(to)) {
      return Arrays.asList(from, to);
    }

    return Collections.emptyList();
  }

  public Boolean getDirected() {
    return directed;
  }

  @Override
  public String toString() {
    return "Graph{" +
        "vertices=" + vertices +
        '}';
  }
}
