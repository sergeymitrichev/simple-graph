package ru.ftob.simplegraph;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GraphDirectedTestGetPath4 {

  private Graph<String> graph;

  @Before
  public void beforeClass() {
    graph = new Graph<>(true);
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addEdge("A", "B");
    graph.addEdge("B", "C");
    graph.addEdge("A", "D");
    graph.addEdge("A", "A");
  }

  @Test
  public void testGetPathSimple() {
    assertEquals(
        Collections.singletonList(new Edge<>("A", "D")),
        graph.getPath("A", "D")
    );
  }

  @Test
  public void testGetPathLoop() {
    assertEquals(
        Collections.singletonList(new Edge<>("A", "A")),
        graph.getPath("A", "A")
    );
  }

  @Test
  public void testGetPath() {
    assertEquals(
        Collections.emptyList(),
        graph.getPath("C", "D")
    );
  }
}
