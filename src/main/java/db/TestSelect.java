package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect {
    public static void main(String[] args) {
        String sql = "SELECT * FROM T1";

        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement(sql)){
            //statement.setLong(1, myID);

            ResultSet rSet = statement.executeQuery();

            while (rSet.next()) {
                long x = rSet.getLong("x");
                long y = rSet.getLong("y");
                System.out.printf("x:%d, y:%d\n",x,y);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}