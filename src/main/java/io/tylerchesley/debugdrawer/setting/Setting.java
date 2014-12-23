package io.tylerchesley.debugdrawer.setting;

import io.tylerchesley.debugdrawer.widget.Renderable;

public abstract class Setting implements Renderable {

    private final String title;

    public Setting(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
