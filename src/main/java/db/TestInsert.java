package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) {
        String sql = "INSERT INTO T1(x, y) VALUES(?,?)";

        try(PreparedStatement statement = DbConnection.getConnection().prepareStatement(sql)){
            statement.setLong(1, 44);
            statement.setLong(2, 55);
            //statement.setString();
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
