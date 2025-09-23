# 項目4 privateのコンストラクタでインスタンス化不可能を強制する

## HOW TO USE

```shell
cd /home/sigma/effective-java-3e-source-code/src/effectivejava/chapter2/item4
java UtilityClass.java
UtilityClass.java:15: error: UtilityClass() has private access in UtilityClass
        UtilityClass uc = new UtilityClass(); // コンパイルエラー
                          ^
1 error
error: compilation failed
```
