package adil.dev.lib.materialnumberpicker.model;

/**
 * Created by Adil on 03/12/2015.
 */
public class IntervalModel {
    int value;
    boolean hasFocus;

    public IntervalModel(int value, boolean hasFocus) {
        this.value = value;
        this.hasFocus = hasFocus;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isHasFocus() {
        return hasFocus;
    }

    public void setHasFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
    }
}
