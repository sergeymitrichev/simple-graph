package ru.ftob.simplegraph;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GraphTestGetPath10 {

  private Graph<String> graph;

  @Before
  public void beforeClass() {
    graph = GraphHelper.generateStringTypeGraph(10, true);
    graph.addEdge("1", "6");
    graph.addEdge("2", "7");
    graph.addEdge("2", "4");
    graph.addEdge("4", "9");
    graph.addEdge("5", "10");
    graph.addEdge("1", "7");
    graph.addEdge("2", "8");
    graph.addEdge("4", "10");
    graph.addEdge("5", "6");

  }

  @Test
  public void testGetPath1() {
    assertEquals(
        Collections.emptyList(),
        graph.getPath("1", "4")
    );
  }

  @Test
  public void testGetPath2() {
    assertEquals(
        Arrays.asList(
            new Edge<>("2", "4"),
            new Edge<>("4", "10")
        ),
        graph.getPath("2", "10")
    );
  }

  @Test
  public void testGetPathNotExist() {
    assertEquals(
        Collections.emptyList(),
        graph.getPath("1", "3")
    );
  }
}
