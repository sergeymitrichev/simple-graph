package ru.ftob.simplegraph;

public class Edge<T> {
  private Vertex<T> from;
  private Vertex<T> to;

  public Edge() {
  }

  public Edge(T from, T to) {
    this(
        new Vertex<>(from),
        new Vertex<>(to)
    );
  }

  public Edge(Vertex<T> from, Vertex<T> to) {
    this.from = from;
    this.to = to;
  }

  public Vertex<T> getFrom() {
    return from;
  }

  public void setFrom(Vertex<T> from) {
    this.from = from;
  }

  public Vertex<T> getTo() {
    return to;
  }

  public void setTo(Vertex<T> to) {
    this.to = to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Edge<?> edge = (Edge<?>) o;

    if (!from.equals(edge.from)) return false;
    return to.equals(edge.to);
  }

  @Override
  public int hashCode() {
    int result = from.hashCode();
    result = 31 * result + to.hashCode();
    return result;
  }


  @Override
  public String toString() {
    return "{" +
        from +
        ", " + to +
        '}';
  }
}
