package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            insert(i*2, i*3);
        }
    }

    public static void insert(int x, int y) {
        String sql = "INSERT INTO T11(x, y) VALUES(?,?)";

        try(PreparedStatement statement = DbConnection.getConnection().prepareStatement(sql)){
            statement.setLong(1, x);
            statement.setLong(2, y);
            //statement.setString();
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
