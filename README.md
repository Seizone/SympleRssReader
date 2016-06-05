Symple Rss Reader
=========

シンプルなRssリーダーです。

Apple、Google、Yahooのニュース記事を取得し、ハイパーリンクで表示しています。

課題が多く残っておりますが、今後はDBに接続し、RSSの登録と削除ができるように改善していきます。

構成
============

* Apache Wicket 7.3.0
* Maven 3

クイックスタート
============

targetフォルダの配下にSympleRssReader-1.0-SNAPSHOT.warがありますので
そちらをWebサーバーにデプロイし、「http://localhost:8080/」へアクセスしご利用ください。

Eclipseからでしたら、\src\test\java\jp\seizo\fujino\Start.javaを右クリックし、「実行 > Javaアプリケーション」で起動します。

