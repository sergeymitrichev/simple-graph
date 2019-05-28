package ru.ftob.simplegraph;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GraphDirectedTestGetPath10 {

  private Graph<String> graph;

  @Before
  public void beforeClass() {
    graph = GraphHelper.generateStringTypeGraph(10, false);
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
        Arrays.asList(
            new Edge<>("1", "6"),
            new Edge<>("6", "5"),
            new Edge<>("5", "10"),
            new Edge<>("10", "4")),
        graph.getPath("1", "4")
    );
  }

  @Test
  public void testGetPath2() {
    assertEquals(
        Arrays.asList(
            new Edge<>("8", "2"),
            new Edge<>("2", "7"),
            new Edge<>("7", "1"),
            new Edge<>("1", "6"),
            new Edge<>("6", "5"),
            new Edge<>("5", "10"),
            new Edge<>("10", "4"),
            new Edge<>("4", "9")
        ),
        graph.getPath("8", "9")
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
