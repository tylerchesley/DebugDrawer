package io.tylerchesley.debugdrawer.setting;

import io.tylerchesley.debugdrawer.R;

public class ImmuttableSetting extends Setting {

    private final String value;

    public ImmuttableSetting(String title, String value) {
        super(title);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int getType() {
        return R.id.debug_drawer_type_immutable_setting;
    }

}
