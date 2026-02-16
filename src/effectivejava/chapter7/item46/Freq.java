package effectivejava.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Frequency table examples showing improper and proper use of stream (Page 210-11)
 * @param args
 * @throws FileNotFoundException
 */ 
public class Freq {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

        // freqをストリームの外部で初期化し、ストリーム内部で更新しているため、ストリームに副作用が発生してしまっている。
//        Map<String, Long> freq = new HashMap<>(); // freq
//        try (Stream<String> words = new Scanner(file).tokens()) {
//            words.forEach(word -> {
//                freq.merge(word.toLowerCase(), 1L, Long::sum);
//            });
//        }
        // ストリームを正しく仕様する例
        Map<String, Long> freq; // 型だけ宣言して、ストリームの外部で初期化しない
        try (Stream<String> words = new Scanner(file).tokens()) {
            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        }
        System.out.println(freq);

        // Collectorsを使用して、頻度の高い単語トップ10を求める例
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed()) // コンパレータを使用して、頻度の高い順にソートする。
                .limit(10)
                .collect(toList()); // toListはstaticメソッドであるため、Collectors.toList()のように書かなくて良い。
        System.out.println(topTen);
    }
}
