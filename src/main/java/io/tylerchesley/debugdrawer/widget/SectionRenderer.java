package io.tylerchesley.debugdrawer.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.tylerchesley.debugdrawer.R;
import io.tylerchesley.debugdrawer.setting.Section;

public class SectionRenderer implements Renderer {

    @Override
    public RendererViewHolder onCreateViewHolder(ViewGroup group) {
        return new SectionViewHolder(LayoutInflater.from(group.getContext())
                .inflate(R.layout.list_item_section, group, false));
    }

    public final class SectionViewHolder extends RendererViewHolder<Section> {

        private final TextView title;

        public SectionViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView;
        }

        @Override
        public void onBindView(Section section) {
            title.setText(section.getTitle());
        }

    }


}
