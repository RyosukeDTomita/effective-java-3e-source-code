# 項目11 equalsをオーバーライドするときは、常にhashCodeをオーバーライドする

## HOW TO USE

```shell
# hashCodeをオーバーライドせず、HashMapが破綻する例
cd /home/sigma/effective-java-3e-source-code/src/effectivejava/chapter3/item11
java PhoneNumberNohashCode.java
```

```shell
# hashCodeをオーバーライドし、HashMapが正しく動作する例
cd /home/sigma/effective-java-3e-source-code/src/effectivejava/chapter3/item11
java PhoneNumber.java
```
