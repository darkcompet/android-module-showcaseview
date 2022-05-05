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

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION_CODES;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(VERSION_CODES.HONEYCOMB)
class MyAnimatorAnimationFactory implements MyAnimationFactory {
	private static final String ALPHA = "alpha";
	private static final float INVISIBLE = 0f;
	private static final float VISIBLE = 1f;

	private final AccelerateDecelerateInterpolator interpolator;

	public MyAnimatorAnimationFactory() {
		interpolator = new AccelerateDecelerateInterpolator();
	}

	@Override
	public void fadeInView(View target, long duration, final AnimationStartListener listener) {
		ObjectAnimator oa = ObjectAnimator.ofFloat(target, ALPHA, INVISIBLE, VISIBLE);
		oa.setDuration(duration).addListener(new AnimatorListenerAdapter() {

			@Override
			public void onAnimationStart(Animator animator) {
				listener.onAnimationStart();
			}

		});
		oa.start();
	}

	@Override
	public void fadeOutView(View target, long duration, final AnimationEndListener listener) {
		ObjectAnimator oa = ObjectAnimator.ofFloat(target, ALPHA, INVISIBLE);
		oa.setDuration(duration).addListener(new AnimatorListenerAdapter() {

			@Override
			public void onAnimationEnd(Animator animator) {
				listener.onAnimationEnd();
			}

		});
		oa.start();
	}

	@Override
	public void animateTargetToPoint(DkShowcaseView showcaseView, Point point) {
		AnimatorSet set = new AnimatorSet();
		ObjectAnimator xAnimator = ObjectAnimator.ofInt(showcaseView, "showcaseX", point.x);
		ObjectAnimator yAnimator = ObjectAnimator.ofInt(showcaseView, "showcaseY", point.y);
		set.playTogether(xAnimator, yAnimator);
		set.setInterpolator(interpolator);
		set.start();
	}

}
