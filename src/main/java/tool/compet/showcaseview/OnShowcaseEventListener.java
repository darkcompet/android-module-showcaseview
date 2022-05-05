/*
 * Copyright 2014 Alex Curran
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tool.compet.showcaseview;

import android.view.MotionEvent;

/**
 * @author Alex
 */
public interface OnShowcaseEventListener {
	/**
	 * Called when the ShowcaseView has been told to hide. Use {@link #onShowcaseViewDidHide(DkShowcaseView)}
	 * if you want to know when the ShowcaseView has been fully hidden.
	 */
	void onShowcaseViewHide(DkShowcaseView showcaseView);

	/**
	 * Called when the animation hiding the ShowcaseView has finished, and it is no longer visible on the screen.
	 */
	void onShowcaseViewDidHide(DkShowcaseView showcaseView);

	/**
	 * Called when the ShowcaseView is shown.
	 */
	void onShowcaseViewShow(DkShowcaseView showcaseView);

	/**
	 * Called when the user has touched on the ShowcaseView, but the touch was blocked
	 *
	 * @param motionEvent the blocked event
	 */
	void onShowcaseViewTouchBlocked(MotionEvent motionEvent);

	/**
	 * Empty implementation of OnShowcaseViewEventListener such that null
	 * checks aren't needed
	 */
	OnShowcaseEventListener NONE = new OnShowcaseEventListener() {
		@Override
		public void onShowcaseViewHide(DkShowcaseView showcaseView) {

		}

		@Override
		public void onShowcaseViewDidHide(DkShowcaseView showcaseView) {

		}

		@Override
		public void onShowcaseViewShow(DkShowcaseView showcaseView) {

		}

		@Override
		public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

		}
	};
}
