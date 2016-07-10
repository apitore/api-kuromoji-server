# api-kuromoji-server
[kuromoji-ipadic-neologd](https://github.com/atilika/kuromoji)をWebAPIにするJavaプロジェクトです。WebAPIは[こちら](https://www.apitore.com/store/apis/details?id=7)で公開しています。本プロジェクトの内容を[ブログ](http://blog.apitore.com/2016/07/11/kuromoji-ipadic-neologd-webapi/ ‎)にしています。


## コンパイルから起動まで

1. [kuromoji-ipadic-neologd](https://github.com/atilika/kuromoji)を「mvn clean install」する。
1. api-kuromoji-serverを「mvn clean package」する。
1. 「java -jar api-kuromoji-server.jar」する。
