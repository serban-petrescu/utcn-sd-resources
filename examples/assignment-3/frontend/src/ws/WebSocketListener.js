import { EventEmitter } from "events";
import { Client } from "@stomp/stompjs";

export default class WebSocketListener extends EventEmitter {
    constructor(username, password) {
        super();
        this.client = new Client({
            brokerURL: "ws://" + username + ":" + password
                + "@localhost:8080/api/websocket",
            onConnect: () => {
                this.client.subscribe("/topic/events", message => {
                    this.emit("event", JSON.parse(message.body));
                })
            }
        });
        this.client.activate();
    }
}