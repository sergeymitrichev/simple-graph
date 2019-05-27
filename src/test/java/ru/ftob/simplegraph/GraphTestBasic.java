package ru.ftob.simplegraph;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GraphTestBasic {

  private Graph<String> graph;

  @Before
  public void beforeClass() {
    graph = new Graph<>();
    graph.addVertex("A");
    graph.addVertex("B");
  }

  @Test
  public void testGetPathNotExist() {
    assertEquals(
        Collections.emptyList(),
        graph.getPath("A", "B")
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddEdgeIllegalFromTypeArgumentException() {
    graph.addEdge("F", "A");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddEdgeIllegalToTypeArgumentException() {
    graph.addEdge("A", "F");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddEdgeIllegalFromVertexArgumentException() {
    graph.addEdge("F", "A");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddEdgeIllegalToVertexArgumentException() {
    graph.addEdge("A", "F");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetPathIllegalFromArgumentException() {
    graph.getPath("E", "A");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetPathIllegalToArgumentException() {
    graph.getPath("A", "E");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetPathIllegalFromAndToArgumentException() {
    graph.getPath("F", "E");
  }
}
