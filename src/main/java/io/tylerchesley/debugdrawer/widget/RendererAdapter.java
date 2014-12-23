package io.tylerchesley.debugdrawer.widget;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.tylerchesley.debugdrawer.setting.HasChildren;

public class RendererAdapter extends RecyclerView.Adapter<Renderer.RendererViewHolder> {

    private final List<? extends Renderable> items;
    private final RendererFactory factory;

    public RendererAdapter(List<? extends Renderable> items) {
        this(items, new DefaultRendererFactory());
    }

    public RendererAdapter(List<? extends Renderable> items, RendererFactory factory) {
        this.items = new FlatMapper().map(items);
        this.factory = factory;
    }

    @Override
    public Renderer.RendererViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Renderer renderer = factory.getRenderer(viewType);
        if (renderer == null) {
            throw new NullPointerException("No renderer found for type " + viewType);
        }
        return renderer.onCreateViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(Renderer.RendererViewHolder holder, int position) {
        final Renderable item = items.get(position);
        holder.onBindView(item);
    }

    @Override
    public int getItemViewType(int position) {
        final Renderable item = items.get(position);
        return item.getType();
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    private static final class FlatMapper {

        private final List<Renderable> mapped = new ArrayList<>();

        public List<Renderable> map(List<? extends Renderable> items) {
            for (Renderable item : items) {
                add(item);
            }
            return mapped;
        }

        private void add(Renderable item) {
            mapped.add(item);
            if (item instanceof HasChildren) {
                final HasChildren parent = (HasChildren) item;
                final int numChildren = parent.numChildren();
                for (int i = 0; i < numChildren; i++) {
                    add(parent.getChild(i));
                }
            }

        }

    }

}
