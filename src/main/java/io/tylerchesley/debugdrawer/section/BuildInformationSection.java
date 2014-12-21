package io.tylerchesley.debugdrawer.section;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.tylerchesley.debugdrawer.BuildConfig;
import io.tylerchesley.debugdrawer.DebugActivityContainer;
import io.tylerchesley.debugdrawer.R;

public class BuildInformationSection implements DebugActivityContainer.Section {

    private final String sha;
    private final String buildDate;

    public BuildInformationSection(String sha, String buildDate) {
        this.sha = sha;
        this.buildDate = buildDate;
    }

    @Override
    public View createView(Activity activity, LayoutInflater inflater, ViewGroup parent) {
        final View view = inflater.inflate(R.layout.debug_section_build_information, parent, false);
        final TextView buildNameView = (TextView) view.findViewById(R.id.debug_build_name);
        final TextView buildCodeView = (TextView) view.findViewById(R.id.debug_build_code);
        final TextView buildShaView = (TextView) view.findViewById(R.id.debug_build_sha);
        final TextView buildDateView = (TextView) view.findViewById(R.id.debug_build_date);
        buildNameView.setText(BuildConfig.VERSION_NAME);
        buildCodeView.setText(String.valueOf(BuildConfig.VERSION_CODE));
        buildShaView.setText(sha);
        buildDateView.setText(buildDate);
        return view;
    }

}
