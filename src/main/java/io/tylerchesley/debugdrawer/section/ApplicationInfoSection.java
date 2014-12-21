package io.tylerchesley.debugdrawer.section;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.tylerchesley.debugdrawer.DebugActivityContainer;
import io.tylerchesley.debugdrawer.R;

public class ApplicationInfoSection implements DebugActivityContainer.Section {

    @Override
    public View createView(Activity activity, LayoutInflater inflater, ViewGroup parent) {
        final ApplicationInfo applicationInfo = activity.getApplicationInfo();
        final View view = inflater.inflate(R.layout.debug_section_application_info, parent, false);
        final TextView applicationLabel = (TextView) view.findViewById(R.id.application_label);
        applicationLabel.setText(applicationInfo.labelRes);
        final ImageView applicationIcon = (ImageView) view.findViewById(R.id.application_icon);
        applicationIcon.setImageDrawable(activity.getPackageManager().getApplicationIcon(applicationInfo));
        return view;
    }

}
