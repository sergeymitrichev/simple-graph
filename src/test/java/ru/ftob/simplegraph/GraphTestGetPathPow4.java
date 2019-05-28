package ru.ftob.simplegraph;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GraphTestGetPathPow4 {

  private Graph<String> graph;

  @Before
  public void beforeClass() {
    graph = new Graph<>();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addEdge("A", "B");
    graph.addEdge("B", "C");
    graph.addEdge("A", "D");
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
        Arrays.asList(new Edge<>("C", "B"), new Edge<>("B", "A"), new Edge<>("A", "D")),
        graph.getPath("C", "D")
    );
  }
}
