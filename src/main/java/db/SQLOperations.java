package db;

import servlet.Operation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLOperations {
  private final static String INSERT = "INSERT INTO T11(x, y) VALUES(?,?)";
  private final static String SELECT_ALL = "SELECT * FROM T11 ORDER BY ID";

  public List<Operation> getOperations() {
    List<Operation> operations = new ArrayList<>();
    try (PreparedStatement statement = DbConnection.getConnection().prepareStatement(SELECT_ALL)){
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
    try(PreparedStatement statement = DbConnection.getConnection().prepareStatement(INSERT)){
      statement.setLong(1, x);
      statement.setLong(2, y);
      //statement.setString();
      statement.executeUpdate();
    }catch (SQLException e){
      e.printStackTrace();
    }
  }

}
