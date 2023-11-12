import { Client } from '@stomp/stompjs';
import { WebSocket } from 'ws';

Object.assign(global, { WebSocket });

const client = new Client({
  brokerURL: 'ws://localhost:8080/gs-guide-websocket',
  onConnect: () => {
    client.subscribe('/topic/greetings', message =>{
      console.log(`Received: ${message.body}`);
    });
    client.publish({ destination: '/app/hello', body: 'クライアントからのMessage' });
  },
});

client.activate();
