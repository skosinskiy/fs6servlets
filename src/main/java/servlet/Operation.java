package servlet;

public class Operation {
  private int id;
  private int x;
  private int y;

  public Operation() {
  }

  public Operation(int id, int x, int y) {
    this.id = id;
    this.x = x;
    this.y = y;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("Operation{id=%d, x=%d, y=%d}", id, x, y);
  }
}
