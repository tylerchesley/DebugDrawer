package io.tylerchesley.debugdrawer.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.tylerchesley.debugdrawer.R;
import io.tylerchesley.debugdrawer.setting.ApplicationHeader;

public class ApplicationHeaderRenderer implements Renderer {

    @Override
    public RendererViewHolder onCreateViewHolder(ViewGroup group) {
        final View view = LayoutInflater.from(group.getContext())
                .inflate(R.layout.list_item_application_header, group, false);
        return new ApplicationHeaderViewHolder(view);
    }

    public static final class ApplicationHeaderViewHolder extends RendererViewHolder<ApplicationHeader> {

        private final TextView title;
        private final TextView subtitle;
        private final ImageView icon;

        public ApplicationHeaderViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            icon = (ImageView) itemView.findViewById(R.id.icon);
        }

        @Override
        public void onBindView(ApplicationHeader applicationHeader) {
            title.setText(applicationHeader.getTitle());
            subtitle.setText(applicationHeader.getSubtitle());
            icon.setImageDrawable(applicationHeader.getIcon());
        }

    }

}
