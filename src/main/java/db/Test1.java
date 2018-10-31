package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) {
        String sql = "INSERT INTO T1(x, y) VALUES(?,?)";

        try(PreparedStatement statement = DbConnection.getConnection().prepareStatement(sql)){
            statement.setLong(1, 33);
            statement.setLong(2, 44);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
