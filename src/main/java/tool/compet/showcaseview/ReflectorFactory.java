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

/**
 * Base class which uses reflection to determine how to showcase Action Items and Action Views.
 */
class ReflectorFactory {
	public static MyReflector getReflectorForActivity(Activity activity) {
		switch (searchForActivitySuperClass(activity)) {
			case STANDARD:
				return new MyActionBarReflector(activity);
			case APP_COMPAT:
				return new MyAppCompatReflector(activity);
			case ACTIONBAR_SHERLOCK:
				return new SherlockReflector(activity);
		}
		return null;
	}

	private static MyReflector.ActionBarType searchForActivitySuperClass(Activity activity) {
		Class currentLevel = activity.getClass();
		while (currentLevel != Activity.class) {
			if (currentLevel.getSimpleName().equals("SherlockActivity") || currentLevel.getSimpleName().equals("SherlockFragmentActivity")) {
				return MyReflector.ActionBarType.ACTIONBAR_SHERLOCK;
			}
			if (currentLevel.getSimpleName().equals("ActionBarActivity")) {
				return MyReflector.ActionBarType.APP_COMPAT;
			}
			currentLevel = currentLevel.getSuperclass();
		}
		return MyReflector.ActionBarType.STANDARD;
	}

}
