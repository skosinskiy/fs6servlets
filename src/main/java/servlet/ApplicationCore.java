package servlet;

import calc.CalculatorManager;
import db.SQLOperations;
import util.FreeMarker;
import util.LoginServer;
import util.NumberGenerator;

public class ApplicationCore {
    private final FreeMarker freeMarker;
    private final NumberGenerator numberGenerator;
    private final LoginServer<String> loginServer;
    private final CalculatorManager manager;
    private final SQLOperations sqlOperations;

    public ApplicationCore() {
        this(
                new FreeMarker("templates"),
                new NumberGenerator(),
                new LoginServer<>(),
                new CalculatorManager(),
                new SQLOperations()
        );
    }

    public ApplicationCore(LoginServer<String> ls) {
        this(
                new FreeMarker("templates"),
                new NumberGenerator(),
                ls,
                new CalculatorManager(),
                new SQLOperations()
        );
    }

    private ApplicationCore(FreeMarker freeMarker, NumberGenerator numberGenerator, LoginServer<String> loginServer, CalculatorManager manager, SQLOperations sqlOperations) {
        this.freeMarker = freeMarker;
        this.numberGenerator = numberGenerator;
        this.loginServer = loginServer;
        this.manager = manager;
        this.sqlOperations = sqlOperations;
    }

    public FreeMarker freeMarker() {
        return freeMarker;
    }

    public NumberGenerator numberGenerator() {
        return numberGenerator;
    }

    public LoginServer<String> loginServer() {
        return loginServer;
    }

    public CalculatorManager manager() {
        return manager;
    }

    public SQLOperations sqlOperations() {
        return sqlOperations;
    }

    public static ApplicationCore build() {
        return new ApplicationCore();
    }
}
