package io.tylerchesley.debugdrawer.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.tylerchesley.debugdrawer.R;
import io.tylerchesley.debugdrawer.setting.Setting;
import io.tylerchesley.rendered.factory.RendererFactory;
import io.tylerchesley.rendered.renderer.Renderer;

public class SettingsRendererFactory<S extends Setting> implements RendererFactory<S> {

    @Override
    public Renderer<S> createRenderer(ViewGroup group, int type) {
        final View view = LayoutInflater.from(group.getContext()).inflate(type, group, false);
        if (type == R.layout.list_item_immutable_setting) {
            return (Renderer<S>)  new ImmutableSettingRenderer(view);
        }
        else if (type == R.layout.list_item_section) {
            return (Renderer<S>) new SectionRenderer(view);
        }
        else if (type == R.layout.list_item_application_header) {
            return (Renderer<S>) new ApplicationHeaderRenderer(view);
        }

        return null;
    }

}
