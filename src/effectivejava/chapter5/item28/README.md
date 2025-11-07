# 項目28 配列よりもリストを選ぶ

## HOW TO USE

```shell
# ジェネリクスの場合コンパイルエラーがでるが、配列は実行時エラーしかでない。
cd ~/effective-java-3e-source-code/src/effectivejava/chapter5/item28
javac ArrayVsList.java
java ArrayVsList.java
```

```shell
# ジェネリックスを使わずにObject配列を使う例(キャストが必要)
cd ~/effective-java-3e-source-code/src/effectivejava/chapter5/item28
java ChooserObject.java

# ジェネリックスを使ってListを使う例(キャスト不要)
cd ~/effective-java-3e-source-code/src/effectivejava/chapter5/item28
java Chooser.java
```
