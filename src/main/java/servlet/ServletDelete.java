package servlet;

import calc.CalculatorManager;
import db.SQLOperations;
import util.FreeMarker;
import util.LoginServer;
import util.NumberGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class ServletDelete extends HttpServlet {
  private final FreeMarker freeMarker;
  private final NumberGenerator numberGenerator;
  private final LoginServer<String> loginServer;
  private final CalculatorManager manager;
  private final SQLOperations sqlOperations;

  public ServletDelete(FreeMarker freeMarker, NumberGenerator numberGenerator, LoginServer<String> loginServer, CalculatorManager manager, SQLOperations sql) {
    this.freeMarker = freeMarker;
    this.numberGenerator = numberGenerator;
    this.loginServer = loginServer;
    this.manager = manager;
    this.sqlOperations = sql;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO PARSE REQ

    // TODO REMOVE RECORD
    resp.sendRedirect("/list");
  }

}
