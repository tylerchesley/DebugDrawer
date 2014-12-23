package io.tylerchesley.debugdrawer.widget;

import io.tylerchesley.debugdrawer.R;

public class DefaultRendererFactory implements RendererFactory {

    @Override
    public Renderer getRenderer(int type) {
        if (type == R.id.debug_drawer_type_section) {
            return new SectionRenderer();
        }
        else if (type == R.id.debug_drawer_type_immutable_setting) {
            return new ImmutableSettingRenderer();
        }
        else if (type == R.id.debug_drawer_type_application_header) {
            return new ApplicationHeaderRenderer();
        }

        return null;
    }

}
