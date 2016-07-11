# api-kuromoji-server
[kuromoji-ipadic-neologd](https://github.com/atilika/kuromoji)をWebAPIにするJavaプロジェクトです。WebAPIは[こちら](https://www.apitore.com/store/apis/details?id=7)で公開しています。本プロジェクトの内容を[ブログ](http://blog.apitore.com/2016/07/11/kuromoji-ipadic-neologd-webapi/ ‎)にしています。


## 実行環境

- Maven 3以上
- JDK 1.8以上


## コンパイルから起動まで

1. [kuromoji-ipadic-neologd](https://github.com/atilika/kuromoji)を「mvn clean install」する。
1. [kuromoji-ipadic](https://github.com/atilika/kuromoji)を「mvn clean install」する。
1. api-kuromoji-serverを「mvn clean package」する。
1. 「java -jar api-kuromoji-server.jar」する。

通常版は「http://localhost:30201/kuromoji-ipadic/open/tokenize?text=hoge」で動きます。neologd版は「http://localhost:30201/kuromoji-ipadic-neologd/open/tokenize?text=hoge」で動きます。「hoge」の部分を適当なテキストで置き換えてください。


## 備考

Apitoreで公開するにあたって内部的にEureka ServerにAPIを登録しに行きますが、Eureka Serverはなくても動作します。また、Apitoreで公開するにあたって入力テキスト長を400文字までとしています。

