package io.tylerchesley.debugdrawer.setting;

import io.tylerchesley.debugdrawer.widget.Renderable;

public interface HasChildren {

    int numChildren();

    Renderable getChild(int position);

}
