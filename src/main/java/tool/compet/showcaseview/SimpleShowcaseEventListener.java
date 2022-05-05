package tool.compet.showcaseview;

import android.view.MotionEvent;

/**
 * Basic implementation of {@link OnShowcaseEventListener} which does nothing
 * for each event, but can be override for each one.
 */
public class SimpleShowcaseEventListener implements OnShowcaseEventListener {
	@Override
	public void onShowcaseViewHide(DkShowcaseView showcaseView) {
		// Override to do stuff
	}

	@Override
	public void onShowcaseViewDidHide(DkShowcaseView showcaseView) {
		// Override to do stuff
	}

	@Override
	public void onShowcaseViewShow(DkShowcaseView showcaseView) {
		// Override to do stuff
	}

	@Override
	public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {
		// Override to do stuff
	}
}
