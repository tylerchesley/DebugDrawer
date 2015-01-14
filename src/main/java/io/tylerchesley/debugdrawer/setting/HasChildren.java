package io.tylerchesley.debugdrawer.setting;

public interface HasChildren {

    int numChildren();

    Setting getChild(int position);

}
