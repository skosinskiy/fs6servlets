import java.util.HashMap;

public class CalculatorManager {
    private final HashMap<Integer, Calculator> calculators = new HashMap<>();
    private int counter = 0;

    private Calculator createNew() {
        int next = ++counter;
        return calculators.put(next, new Calculator(next));
    }

    public Calculator getOrCreate(int id) {
        return calculators.getOrDefault(id, createNew());
    }
}
