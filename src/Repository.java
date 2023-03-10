import java.util.Observable;

public class Repository extends Observable {
    private static final Repository instance = new Repository();

    String blockToDraw;

    private Repository() {
        this.blockToDraw = "";
    }

    public static Repository getInstance() {
        return instance;
    }

    public void updateOption(String option) {
        setChanged();
        notifyObservers(option);
    }
}
