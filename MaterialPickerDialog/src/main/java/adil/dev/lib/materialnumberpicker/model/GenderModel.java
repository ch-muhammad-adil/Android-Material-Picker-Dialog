package adil.dev.lib.materialnumberpicker.model;

/**
 * Created by Adil on 08/01/2016.
 */
public class GenderModel {
    String gender;
    boolean hasFocus;

    public GenderModel(String gender, boolean hasFocus) {
        this.gender = gender;
        this.hasFocus = hasFocus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHasFocus() {
        return hasFocus;
    }

    public void setHasFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
    }
}
