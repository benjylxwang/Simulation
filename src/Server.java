import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        port(7777);
        webSocket("/ws", WSHandler.class);
        staticFiles.externalLocation(System.getProperty("user.dir") + "/public");
        setupRoutes();
    }

    private static void setupRoutes() {
        get("/hello", (request, response) -> {
            return "Hello world!";
        });
    }
}
