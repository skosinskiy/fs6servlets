public class Calculator {
    private final int id;
    private boolean hasData = false;
    private int x;
    private int y;

    public Calculator(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setData(String x, String y) {
        setData(
                Integer.parseInt(x),
                Integer.parseInt(y));
    }

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
