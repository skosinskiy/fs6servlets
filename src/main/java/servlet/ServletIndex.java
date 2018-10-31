package servlet;

import entity.Item;
import entity.User;
import util.FreeMarker;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ServletIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // https://freemarker.apache.org

        FreeMarker templates = new FreeMarker("templates");

        List<Item> items = IntStream.range(1, 5)
                .mapToObj(val -> new Item(val, "Name " + val))
                .collect(Collectors.toList());

        HashMap<String, Object> data = new HashMap<>();
        data.put("user", new User("Alex"));
        data.put("user1", "DIMA");
        data.put("items", items);

        templates.render("index.html", data, resp);
    }
}
