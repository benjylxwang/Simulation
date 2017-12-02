let ws;
let current_game;

function init() {
    ws = new WebSocket("ws://" + window.location.hostname + ":" + window.location.port + "/ws");
    ws.onopen(console.log("Websocket opened!"));
    ws.onmessage(messageHandler);
}

function startGame() {
    // Get values from form
    let name = $("#name").val();
    let status = $("#status").val();
    let type = $("#type").val();

    let data = { type: "new_game", name: name, status: status, character_type: type };
    ws.send(JSON.stringify(data));
}

function messageHandler(event) {
    let msg = JSON.parse(event.data);
    switch(msg.type) {
        case "new_game":
            switchView(true);
            current_game = new Game(msg);
            break;
        case "update":
        case "require_input":
        case "new_turn":
        case "response":
    }
}

function switchView(game) {
    $("newGame").toggle(!game);
    $("game").toggle(game);
}