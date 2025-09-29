import java.util.function.Consumer;

public class ConfigUI {
    private final Consumer<ConfigModel> onSave;
    public ConfigUI(Consumer<ConfigModel> onSave) {
        this.onSave = onSave;
    }
    public void handleSaveButton() {
        ConfigModel newConfig = new ConfigModel("NewProvider");
        this.onSave.accept(newConfig);
    }
}
