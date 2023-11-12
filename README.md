# web socket通信お試し
## 動作検証方法
1. SpringBootApplication立ち上げ
2. client立ち上げ
    ```sh 
    cd stompJsClient
    npm ci 
    node index.js
    ```
3. 動作確認用エンドポイントを叩く
    ```sh
    curl -X PUT "http://localhost:8080/test/hello" -d '{"name": "message"}' -H 'Content-Type:application/json'
    ```
