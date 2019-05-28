package ru.ftob.simplegraph;

import java.util.*;

public class Graph<T> {

  private final boolean directed;

  private Map<Vertex<T>, List<Vertex<T>>> vertices = new HashMap<>();

  private Set<Vertex<T>> visited = new HashSet<>();

  public Graph() {
    this(false);
  }

  public Graph(boolean directed) {
    this.directed = directed;
  }

  public void addVertex(T type) {
    addVertex(new Vertex<>(type));
  }

  public void addVertex(Vertex<T> vertex) {
    vertices.putIfAbsent(vertex, new ArrayList<>());
  }

  /**
   * Adds edge to graph by vertices.
   * Direction of arc (directed graph): from --&gt; to
   *
   * @param from vertex type value of edge
   * @param to   vertex type value of edge
   * @throws IllegalArgumentException if edge vertices are not
   *                                  part of graph
   */
  public void addEdge(Vertex<T> from, Vertex<T> to) {
    validateVertices(from, to);
    vertices.get(from).add(to);
    if (!directed) {
      vertices.get(to).add(from);
    }
  }

  /**
   * Adds edge to graph by vertices types.
   * Direction of arc (directed graph): from --&gt; to
   *
   * @param from vertex type value of edge
   * @param to   vertex type value of edge
   * @throws IllegalArgumentException if edge vertices are not
   *                                  part of graph
   */
  public void addEdge(T from, T to) {
    addEdge(new Vertex<>(from), new Vertex<>(to));
  }

  /**
   * Adds edge to graph.
   *
   * @param edge edge to add
   * @throws IllegalArgumentException if edge vertices are not
   *                                  part of graph
   */
  public void addEdge(Edge<T> edge) {
    addEdge(edge.getFrom(), edge.getTo());
  }

  /**
   * Returns list of edges of the found path. If path is not found,
   * an empty list is returned. If the start and end of the path are the same,
   * the vertex loop will be returned (if it exists)
   * <p>
   * Path is not optimal.
   *
   * @param from starting point of the path
   * @param to   the endpoint of the path
   * @return list of edges of the found path
   * @throws IllegalArgumentException if the start or end points are not
   *                                  part of the graph
   */
  public List<Edge<T>> getPath(T from, T to) {

    Vertex<T> v1 = new Vertex<>(from);
    Vertex<T> v2 = new Vertex<>(to);

    validateVertices(v1, v2);

    ArrayList<Edge<T>> edges = new ArrayList<>();
    getPathByBreadthFirstSearch(v1, v2).stream().reduce((f, t) -> {
      edges.add(new Edge<>(f, t));
      return t;
    });
    return edges;
  }

  private List<Vertex<T>> getPathByBreadthFirstSearch(Vertex<T> from, Vertex<T> to) {

    if (vertices.get(from).contains(to)) {
      return Arrays.asList(from, to);
    }

    visited.add(from);

    for (Vertex<T> node : vertices.get(from)) {
      if (!visited.contains(node)) {
        ArrayList<Vertex<T>> subPath = new ArrayList<>(getPathByBreadthFirstSearch(node, to));
        if (subPath.contains(to)) {
          subPath.add(0, from);
          return subPath;
        }
      }
    }
    return Collections.emptyList();
  }

  @SafeVarargs
  private final void validateVertices(Vertex<T>... toValidate) {
    if (!vertices.keySet().containsAll(Arrays.asList(toValidate))) {
      throw new IllegalArgumentException("Vertices must be part of the graph");
    }
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
