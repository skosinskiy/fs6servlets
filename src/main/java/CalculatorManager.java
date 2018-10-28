import java.util.HashMap;

public class CalculatorManager {
    private final HashMap<Integer, Calculator> calculators = new HashMap<>();
    private int counter = 0;

    private Calculator create(int id) {
        Calculator c = new Calculator(id);
        calculators.put(id, c);
        return c;
    }

    public Calculator getOrCreate() {
        int next = ++counter;
        Calculator c = new Calculator(next);
        calculators.put(next, c);
        return c;
    }

    public Calculator getOrCreate(int id) {
        return calculators.containsKey(id) ?
                calculators.get(id) : create(id);
    }
}
