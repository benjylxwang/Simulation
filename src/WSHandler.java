import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@WebSocket
public class WSHandler {
    private static final HashMap<Session, Integer> sessions = new HashMap<>();
    private static final int IDLE = 0;
    private static final int INPUT_REQUESTED = 1;
    private static final int USER_TURN = 2;
    private static final int WAITING = 3;

    @OnWebSocketConnect
    public void connected(Session session) {
        sessions.put(session, IDLE);
    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {
        sessions.remove(session);
    }

    @OnWebSocketMessage
    public void message(Session session, String message) throws IOException {
        JSONObject object = new JSONObject(message);
        String type = object.getString("type");
        switch(type) {
            case "response":
                if (sessions.get(session) == INPUT_REQUESTED) {
                    // TODO
                }
                break;
            case "action":
                if (sessions.get(session) == USER_TURN) {
                    // TODO
                }
                break;
            case "new_game":
                if (sessions.get(session) == IDLE) {
                    // TODO: Start a game
                    sessions.put(session, WAITING);
                }
        }
    }
}
