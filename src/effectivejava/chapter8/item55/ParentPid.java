package effectivejava.chapter8.item55;

import java.util.Optional;

/**
 * プロセスの親プロセスIDを表示するサンプル
 */
public class ParentPid {
    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();

        // isPresent()は値がある時にtrueを返すのでこのチェックの後にget()を呼び出している例。ほぼnullチェックと変わらない
        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("Parent PID: " + (parentProcess.isPresent() ?
                String.valueOf(parentProcess.get().pid()) : "N/A"));

        // Optionalの提供するmapやorElseを使って書き換えると読みやすい。
        System.out.println("Parent PID: " +
            ph.parent()
            .map(h -> String.valueOf(h.pid()))
            .orElse("N/A"));
    }
}
