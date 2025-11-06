## 背景

- ConfigModelをImmutableに変更したため、コンストラクタでパラメータを設定するようなった。
- すると、MainクラスでnewしたインスタンスをAnalsisEngineクラスにコンストラクタで渡してシステムを初期化しておき、後ほど、ConfigUIクラスから値を設定するということができなくなってしまった。

### 解決したいこと

ConfigModelをImmutableにしつつ、AnalysisEngineのメソッド実行時にConfigModelのインスタンスを渡すという運用を避けたい。AnalysisEngineのインスタンス変数にConfigModelのインスタンスがある形がベスト

---

## 解決方法

AtomicReferenceを使い、初期化前のAnalysisEngineのコンストラクタにConfigModelの参照をSupplierとして渡すようにした。 --> ConfigModelを後から差し替えるために利用している。

これにより、ConfigUIで後から生成されるConfigModelのインスタンスをAnalysisEngineのメソッド実行時に使用できるようになった。 --> AnalysisEngineはいつでも最新のConfigModelを参照できる。

### 説明

- AtomicReference: 任意のオブジェクトの参照をスレッドセーフに保持するためのクラス。
- `Supplier<T>`: 引数を受け取らずに値を提供する関数型インターフェース
- `Consumer<T>`: 単一の入力引数を受取、その処理を実行するだけで結果は返さない関数型インターフェース。副作用を伴う処理に使う。
