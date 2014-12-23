package io.tylerchesley.debugdrawer.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.tylerchesley.debugdrawer.R;
import io.tylerchesley.debugdrawer.setting.ImmuttableSetting;

public class ImmutableSettingRenderer implements Renderer {

    @Override
    public RendererViewHolder onCreateViewHolder(ViewGroup group) {
        return new SimpleValueViewHolder(LayoutInflater.from(group.getContext())
                .inflate(R.layout.list_item_immutable_setting, group, false));
    }

    public static final class SimpleValueViewHolder extends RendererViewHolder<ImmuttableSetting> {

        private final TextView title;
        private final TextView value;

        public SimpleValueViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            value = (TextView) itemView.findViewById(R.id.value);
        }

        @Override
        public void onBindView(ImmuttableSetting immuttableSetting) {
            title.setText(immuttableSetting.getTitle());
            value.setText(immuttableSetting.getValue());
        }

    }

}
