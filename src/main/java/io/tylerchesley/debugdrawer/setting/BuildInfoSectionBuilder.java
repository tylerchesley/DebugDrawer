package io.tylerchesley.debugdrawer.setting;

import android.content.Context;

import io.tylerchesley.debugdrawer.BuildConfig;
import io.tylerchesley.debugdrawer.R;

public class BuildInfoSectionBuilder extends SectionBuilder {

    public static BuildInfoSectionBuilder from(Context context) {
        return new BuildInfoSectionBuilder(context);
    }

    public BuildInfoSectionBuilder(Context context) {
        super(context);
        title(R.string.debug_header_build_information);
        addDefaults();
    }

    public BuildInfoSectionBuilder addVersionName() {
        add(R.string.debug_build_version_name, BuildConfig.VERSION_NAME);
        return this;
    }

    public BuildInfoSectionBuilder addVersionCode() {
        add(R.string.debug_build_version_code, String.valueOf(BuildConfig.VERSION_CODE));
        return this;
    }

    public BuildInfoSectionBuilder addDefaults() {
        return addVersionName()
                .addVersionCode();
    }

}
