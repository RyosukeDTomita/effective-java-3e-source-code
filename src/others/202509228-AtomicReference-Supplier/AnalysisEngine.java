import java.util.function.Supplier;

public class AnalysisEngine {
    private final Supplier<ConfigModel> configSupplier;

    public AnalysisEngine(Supplier<ConfigModel> configSupplier) {
        this.configSupplier = configSupplier;
    }

    public void analyze(String request) {
        ConfigModel config = this.configSupplier.get();
        System.out.println("Analyzing request with provider=" + config.getProvider());
    }
}
