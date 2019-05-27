package ru.ftob.simplegraph;

public class Vertex<T> {
  private T type;

  public Vertex(T type) {
    this.type = type;
  }

  public T getType() {
    return type;
  }

  public void setType(T type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Vertex vertex = (Vertex) o;

    return type != null ? type.equals(vertex.type) : vertex.type == null;
  }

  @Override
  public int hashCode() {
    return type != null ? type.hashCode() : 0;
  }


  @Override
  public String toString() {
    return "{" + type + '}';
  }
}
