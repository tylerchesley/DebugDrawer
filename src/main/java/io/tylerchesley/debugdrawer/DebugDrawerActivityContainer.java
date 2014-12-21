package io.tylerchesley.debugdrawer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DebugDrawerActivityContainer implements ActivityContainer {

    public static interface Section {

        public View createView(Activity activity, LayoutInflater inflater, ViewGroup parent);

    }

    private final int containerLayoutResource;
    private final List<Section> sections;

    public DebugDrawerActivityContainer(List<Section> sections) {
        this(R.layout.debug_default_activity_container, sections);
    }

    public DebugDrawerActivityContainer(int containerLayoutResource, List<Section> sections) {
        this.containerLayoutResource = containerLayoutResource;
        this.sections = sections;
    }

    @Override
    public void setContentView(Activity activity, int layoutResource) {
        activity.setContentView(containerLayoutResource);

        final ViewGroup contentContainer = (ViewGroup) activity
                .findViewById(R.id.debug_content_container);
        if (contentContainer == null) {
            throw new NullPointerException("No container with an id of 'debug_content_container' "
                    + "found");
        }

        LayoutInflater.from(activity).inflate(layoutResource, contentContainer);

        final ViewGroup drawerContainer = (ViewGroup) activity
                .findViewById(R.id.debug_drawer_container);
        if (drawerContainer == null) {
            throw new NullPointerException("No container with id of 'debug_drawer_container' "
                    + "found.");
        }

        final LayoutInflater inflater = activity.getLayoutInflater();
        for (Section section : sections) {
            final View view = section.createView(activity, inflater, drawerContainer);
            drawerContainer.addView(view);
        }
    }

}
