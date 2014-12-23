package io.tylerchesley.debugdrawer.setting;

import java.util.ArrayList;
import java.util.List;

import io.tylerchesley.debugdrawer.R;
import io.tylerchesley.debugdrawer.widget.Renderable;

public class Section extends Setting implements HasChildren {

    private final List<Renderable> children;

    public Section(String title) {
        this(title, new ArrayList<Renderable>());
    }

    public Section(String title, List<Renderable> children) {
        super(title);
        this.children = children;
    }

    @Override
    public int getType() {
        return R.id.debug_drawer_type_section;
    }

    @Override
    public int numChildren() {
        return children.size();
    }

    @Override
    public Renderable getChild(int position) {
        return children.get(position);
    }

}
