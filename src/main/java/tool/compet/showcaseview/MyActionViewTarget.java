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

import android.app.Activity;
import android.graphics.Point;
import android.view.ViewParent;

class MyActionViewTarget implements MyTarget {
	private final Activity mActivity;
	private final Type mType;

	MyActionBarViewWrapper mActionBarWrapper;
	MyReflector mReflector;

	public MyActionViewTarget(Activity activity, Type type) {
		mActivity = activity;
		mType = type;
	}

	protected void setUp() {
		mReflector = ReflectorFactory.getReflectorForActivity(mActivity);
		ViewParent p = mReflector.getActionBarView(); //ActionBarView
		mActionBarWrapper = new MyActionBarViewWrapper(p);
	}

	@Override
	public Point getPoint() {
		MyTarget internal = null;
		setUp();

		switch (mType) {
			case SPINNER:
				internal = new MyViewTarget(mActionBarWrapper.getSpinnerView());
				break;

			case HOME:
				internal = new MyViewTarget(mReflector.getHomeButton());
				break;

			case OVERFLOW:
				internal = new MyViewTarget(mActionBarWrapper.getOverflowView());
				break;

			case TITLE:
				internal = new MyViewTarget(mActionBarWrapper.getTitleView());
				break;

			case MEDIA_ROUTE_BUTTON:
				internal = new MyViewTarget(mActionBarWrapper.getMediaRouterButtonView());
				break;

		}
		return internal.getPoint();
	}

	public enum Type {
		SPINNER, HOME, TITLE, OVERFLOW, MEDIA_ROUTE_BUTTON
	}
}
