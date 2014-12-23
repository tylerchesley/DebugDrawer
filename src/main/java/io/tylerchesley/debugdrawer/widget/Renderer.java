package io.tylerchesley.debugdrawer.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public interface Renderer {

    RendererViewHolder onCreateViewHolder(ViewGroup group);

    public abstract static class RendererViewHolder<R extends Renderable>
            extends RecyclerView.ViewHolder {

        public RendererViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void onBindView(R renderable);

    }

}
