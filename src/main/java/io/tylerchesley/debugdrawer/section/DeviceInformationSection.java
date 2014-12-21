package io.tylerchesley.debugdrawer.section;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.tylerchesley.debugdrawer.DebugDrawerActivityContainer;
import io.tylerchesley.debugdrawer.R;

public class DeviceInformationSection implements DebugDrawerActivityContainer.Section {

    private static String getDensityString(DisplayMetrics displayMetrics) {
        switch (displayMetrics.densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                return "ldpi";
            case DisplayMetrics.DENSITY_MEDIUM:
                return "mdpi";
            case DisplayMetrics.DENSITY_HIGH:
                return "hdpi";
            case DisplayMetrics.DENSITY_XHIGH:
                return "xhdpi";
            case DisplayMetrics.DENSITY_XXHIGH:
                return "xxhdpi";
            case DisplayMetrics.DENSITY_XXXHIGH:
                return "xxxhdpi";
            case DisplayMetrics.DENSITY_TV:
                return "tvdpi";
            default:
                return "unknown";
        }
    }

    @Override
    public View createView(Activity activity, LayoutInflater inflater, ViewGroup parent) {
        final View view = inflater.inflate(R.layout.debug_section_device_information, parent,
                false);
        final DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        final TextView deviceMakeView = (TextView) view.findViewById(R.id.debug_device_make);
        final TextView deviceModelView = (TextView) view.findViewById(R.id.debug_device_model);
        final TextView deviceResolutionView = (TextView) view.findViewById(
                R.id.debug_device_resolution);
        final TextView deviceDensityView = (TextView) view.findViewById(R.id.debug_device_density);
        final TextView deviceReleaseView = (TextView) view.findViewById(R.id.debug_device_release);
        final TextView deviceApiView = (TextView) view.findViewById(R.id.debug_device_api);

        deviceMakeView.setText(Build.MANUFACTURER);
        deviceModelView.setText(Build.MODEL);
        deviceResolutionView.setText(displayMetrics.heightPixels + "x"
                + displayMetrics.widthPixels);
        deviceDensityView.setText(displayMetrics.densityDpi + "dpi ("
                + getDensityString(displayMetrics) + ")");
        deviceReleaseView.setText(Build.VERSION.RELEASE);
        deviceApiView.setText(String.valueOf(Build.VERSION.SDK_INT));

        return view;
    }

}
