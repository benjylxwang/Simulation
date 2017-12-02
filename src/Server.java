import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class Server {
    public static void main(String[] args) {
        port(7777);
        staticFiles.externalLocation(System.getProperty("user.dir") + "/public");
        setupRoutes();
    }

    private static void setupRoutes() {
        get("/hello", (request, response) -> {
            return "Hello world!";
        });
    }
}
