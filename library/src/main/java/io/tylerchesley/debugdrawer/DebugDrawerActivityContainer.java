package io.tylerchesley.debugdrawer;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.tylerchesley.debugdrawer.widget.DividerItemDecoration;

public class DebugDrawerActivityContainer implements ActivityContainer {

    private final int containerLayoutResource;
    private final RecyclerView.Adapter adapter;

    public DebugDrawerActivityContainer(RecyclerView.Adapter adapter) {
        this(R.layout.debug_default_activity_container, adapter);
    }

    public DebugDrawerActivityContainer(int containerLayoutResource,
                                        RecyclerView.Adapter adapter) {
        this.containerLayoutResource = containerLayoutResource;
        this.adapter = adapter;
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

        final RecyclerView drawerContainer = (RecyclerView) activity
                .findViewById(R.id.debug_drawer_container);
        if (drawerContainer == null) {
            throw new NullPointerException("No container with id of 'debug_drawer_container' "
                    + "found.");
        }

        drawerContainer.setHasFixedSize(true);
        drawerContainer.setLayoutManager(new LinearLayoutManager(activity));
        drawerContainer.addItemDecoration(new DividerItemDecoration(activity,
                DividerItemDecoration.VERTICAL_LIST));
        drawerContainer.setAdapter(adapter);
    }

}
