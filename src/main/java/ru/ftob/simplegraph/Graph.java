package ru.ftob.simplegraph;

import java.util.*;

public class Graph<T> {

  private Boolean directed;

  private Map<Vertex<T>, List<Vertex<T>>> vertices = new HashMap<>();

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
