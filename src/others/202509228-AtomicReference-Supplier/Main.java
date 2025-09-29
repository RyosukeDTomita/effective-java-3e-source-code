import java.util.concurrent.atomic.AtomicReference;


public class Main {

    public static void main(String[] args) {
        // AtomicReferenceでConfigModelがnewされる前に引数として他クラスに渡せるようにする
        AtomicReference<ConfigModel> configRef = new AtomicReference<>();
        AnalysisEngine engine = new AnalysisEngine(configRef::get);

        ConfigUI ui = new ConfigUI(newConfig -> {
            configRef.set(newConfig);
        });

        // UI経由でConfigModelのインスタンスを作成する。(本来はUIのイベントで呼ばれる)
        ui.handleSaveButton();

        engine.analyze("request-example");
    }
}
