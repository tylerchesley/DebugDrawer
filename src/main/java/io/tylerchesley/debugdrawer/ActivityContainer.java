package io.tylerchesley.debugdrawer;

import android.app.Activity;

public interface ActivityContainer {


//region Methods
//-----------------------------------------------------------------------------

    public void setContentView(Activity activity, int layoutResource);

//-----------------------------------------------------------------------------
//endregion


//region Inner Classes
//-----------------------------------------------------------------------------

    public static final class DefaultActivityContainer implements ActivityContainer {

        @Override
        public void setContentView(Activity activity, int layoutResource) {
            activity.setContentView(layoutResource);
        }

    }

//-----------------------------------------------------------------------------
//endregion


}
