package db;

public class TestInsert {
    public static void main(String[] args) {
        SQLOperations sql = new SQLOperations();
        for (int i = 0; i < 10; i++) {
            sql.insertOperation(i*2, i*3);
        }
    }
}
