package servlet;

import calc.CalculatorManager;
import db.DbConnection;
import db.SQLOperations;
import org.eclipse.jetty.servlet.Source;
import util.FreeMarker;
import util.LoginServer;
import util.NumberGenerator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServletList extends HttpServlet {
  private final FreeMarker freeMarker;
  private final NumberGenerator numberGenerator;
  private final LoginServer<String> loginServer;
  private final CalculatorManager manager;

  public ServletList(FreeMarker freeMarker, NumberGenerator numberGenerator, LoginServer<String> loginServer, CalculatorManager manager) {
    this.freeMarker = freeMarker;
    this.numberGenerator = numberGenerator;
    this.loginServer = loginServer;
    this.manager = manager;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();
    List<Operation> al = new SQLOperations().getOperations();
    data.put("user", "Anybody");
    data.put("operations", al);
    freeMarker.render("operationsList.html", data, resp);
  }

}
