# Javaの並列処理勉強用

## HOW TO USE

```shell
# Threadを継承したクラスを使い方の例
cd ~/effective-java-3e-source-code/src/others/20251010-parallel
javac ThreadExample.java
java ThreadExample
```

```shell
# Runnableインターフェースを実装したクラスを使い方の例
cd ~/effective-java-3e-source-code/src/others/20251010-parallel
javac RunnableExample.java
java RunnableExample
```

```shell
# Runnableインターフェースをラムダ式で実装し、並列処理を行う例
cd ~/effective-java-3e-source-code/src/others/20251010-parallel
java RunnableLambdaExample.java
# Worker-1と2のスレッドがバラバラに出力されているため、スレッド並列処理が行われていることがわかる。
Worker-2 → 1
Worker-1 → 1
Worker-2 → 2
Worker-1 → 2
Worker-2 → 3
Worker-1 → 3
Worker-1 → 4
Worker-2 → 4
Worker-1 → 5
Worker-2 → 5
```
