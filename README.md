web socket通信お試し

1. SpringBootApplication立ち上げ
1. client立ち上げ
```sh 
cd stompJsClient
npm ci 
node index.js
```

1. 動作確認用エンドポイントを叩く
```sh
curl -X PUT "http://localhost:8080/hello" -d '{"name": "message"}' -H 'Content-Type:application/json'
```
