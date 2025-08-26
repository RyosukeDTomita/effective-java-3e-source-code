#!/bin/bash
java InstrumentedHashSet.java

# 複数ファイルに分割されている場合
javac -d out ./ForwardingSet.java ./InstrumentedSet.java
java -cp out effectivejava.chapter4.item18.InstrumentedSet