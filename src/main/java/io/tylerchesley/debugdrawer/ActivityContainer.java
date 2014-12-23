package io.tylerchesley.debugdrawer;

import android.app.Activity;

public interface ActivityContainer {

    public void setContentView(Activity activity, int layoutResource);

    public static final class DefaultActivityContainer implements ActivityContainer {

        @Override
        public void setContentView(Activity activity, int layoutResource) {
            activity.setContentView(layoutResource);
        }

    }

}
