package db;

import servlet.Operation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLOperations {
  public List<Operation> getOperations() {
    List<Operation> operations = new ArrayList<>();
    String sql = "SELECT * FROM T11 ORDER BY ID";

    try (PreparedStatement statement = DbConnection.getConnection().prepareStatement(sql)){
      //statement.setLong(1, myID);

      ResultSet rSet = statement.executeQuery();
      while (rSet.next()) {
        operations.add(new Operation(
            rSet.getInt("id"),
            rSet.getInt("x"),
            rSet.getInt("y")
        ));
      }

    } catch (SQLException e){
      e.printStackTrace();
    }
    return operations;
  }

  public void insertOperation(int x, int y) {
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
