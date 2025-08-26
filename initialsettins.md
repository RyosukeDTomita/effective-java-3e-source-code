# Java初期セットアップ等

## Javaの基礎

### バージョンの見方

Java8までのバージョン表記は、`1.x.0_y`のようになっており、`1.`の部分は省略されることが多い。例えば、Java 8 Update 151は`1.8.0_151`と表記される[^1]。
Java9以降は、`9.0.1`や`11.0.2`のように、`1.`の部分がなくなり、メジャーバージョンがそのまま表記されるようになった[^2]

### JDKとJRE

JREはランタイムだけ[^3]。

---

## JavaをInstallする

Javaの後方互換性を信じて、適当に新しいやつを入れた。

```shell
sudo apt install openjdk-21-jdk
```

---

## Javaを実行する

### 単一ファイル

```shell
# 実行例
java ./src/effectivejava/chapter4/item18/InstrumentedHashSet.java
```

### 複数ファイル

```shell
cd effective-java-3e-source-code/src/effectivejava/chapter4/item18
javac -d out ./ForwardingSet.java ./InstrumentedSet.java
java -cp out effectivejava.chapter4.item18.InstrumentedSet
```

---

## Reference

[^1]:(<https://www.oracle.com/java/technologies/javase/jdk8-naming.html>)
[^2]:(<https://stackoverflow.com/questions/2411288/java-versioning-and-terminology-1-6-vs-6-0-openjdk-vs-sun>)
[^3]:(<https://wa3.i-3-i.info/diff1117programming.html>)
