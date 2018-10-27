public class Calculator {
    private boolean hasData = false;
    private int x;
    private int y;

    public void setData(int x, int y) {
        this.x = x;
        this.y = y;
        hasData = true;
    }

    public int add() {
        if (hasData) {
            return x + y;
        } else {
            throw new IllegalArgumentException("There is no data to calculation");
        }
    }
}
