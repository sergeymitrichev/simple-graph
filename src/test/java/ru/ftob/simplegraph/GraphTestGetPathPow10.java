package ru.ftob.simplegraph;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GraphTestGetPathPow10 {

  private Graph<String> graph;

  @Before
  public void beforeClass() {
    graph = new Graph<>();
    graph.addVertex("1");
    graph.addVertex("2");
    graph.addVertex("3");
    graph.addVertex("4");
    graph.addVertex("5");
    graph.addVertex("6");
    graph.addVertex("7");
    graph.addVertex("8");
    graph.addVertex("9");
    graph.addVertex("10");
    graph.addEdge("1", "6");
    graph.addEdge("2", "7");
    graph.addEdge("3", "8");
    graph.addEdge("4", "9");
    graph.addEdge("5", "10");
    graph.addEdge("1", "7");
    graph.addEdge("2", "8");
    graph.addEdge("3", "9");
    graph.addEdge("4", "10");
    graph.addEdge("5", "6");

  }

  @Test
  public void testGetPath() {
    assertEquals(
        Arrays.asList(
            new Edge<>("1", "6"),
            new Edge<>("6", "5"),
            new Edge<>("5", "10"),
            new Edge<>("10", "4")),
        graph.getPath("1", "4")
    );
  }
}
