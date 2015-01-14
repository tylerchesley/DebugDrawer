package io.tylerchesley.debugdrawer.setting;

public abstract class Setting {

    private final String title;

    public Setting(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
