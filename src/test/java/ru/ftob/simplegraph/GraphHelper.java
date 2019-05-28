package ru.ftob.simplegraph;

class GraphHelper {

  static Graph<String> generateStringTypeGraph(
      int numberOfVertices,
      boolean isDirected
  ) {
    Graph<String> graph = new Graph<>(isDirected);
    for (int i = 0; i < numberOfVertices; i++) {
      graph.addVertex(Integer.toString(i + 1));
    }
    return graph;
  }
}
