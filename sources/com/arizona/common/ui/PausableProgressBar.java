package com.arizona.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.ExoPlayer;
import com.arizona.common.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class PausableProgressBar extends FrameLayout {
    private static final int DEFAULT_PROGRESS_DURATION = 2000;
    private PausableScaleAnimation animation;
    private Callback callback;
    private long duration;
    private View frontProgressView;
    private View maxProgressView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Callback {
        void onFinishProgress();

        void onStartProgress();
    }

    public PausableProgressBar(Context context) {
        this(context, null);
    }

    public PausableProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PausableProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duration = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        LayoutInflater.from(context).inflate(R.layout.pausable_progress, this);
        this.frontProgressView = findViewById(R.id.front_progress);
        this.maxProgressView = findViewById(R.id.max_progress);
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMax() {
        finishProgress(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMin() {
        finishProgress(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMinWithoutCallback() {
        this.maxProgressView.setBackgroundResource(R.color.progress_secondary);
        this.maxProgressView.setVisibility(0);
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            this.animation.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxWithoutCallback() {
        this.maxProgressView.setBackgroundResource(R.color.progress_max_active);
        this.maxProgressView.setVisibility(0);
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            this.animation.cancel();
        }
    }

    private void finishProgress(boolean z) {
        if (z) {
            this.maxProgressView.setBackgroundResource(R.color.progress_max_active);
        }
        this.maxProgressView.setVisibility(z ? 0 : 8);
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            this.animation.cancel();
            Callback callback = this.callback;
            if (callback != null) {
                callback.onFinishProgress();
            }
        }
    }

    public void startProgress() {
        this.maxProgressView.setVisibility(8);
        PausableScaleAnimation pausableScaleAnimation = new PausableScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 0, 0.0f, 1, 0.0f);
        this.animation = pausableScaleAnimation;
        pausableScaleAnimation.setDuration(this.duration);
        this.animation.setInterpolator(new LinearInterpolator());
        this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.arizona.common.ui.PausableProgressBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                PausableProgressBar.this.frontProgressView.setVisibility(0);
                if (PausableProgressBar.this.callback != null) {
                    PausableProgressBar.this.callback.onStartProgress();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (PausableProgressBar.this.callback != null) {
                    PausableProgressBar.this.callback.onFinishProgress();
                }
            }
        });
        this.animation.setFillAfter(true);
        this.frontProgressView.startAnimation(this.animation);
    }

    public void pauseProgress() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.pause();
        }
    }

    public void resumeProgress() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            this.animation.cancel();
            this.animation = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class PausableScaleAnimation extends ScaleAnimation {
        private long mElapsedAtPause;
        private boolean mPaused;

        PausableScaleAnimation(float f, float f2, float f3, float f4, int i, float f5, int i2, float f6) {
            super(f, f2, f3, f4, i, f5, i2, f6);
            this.mElapsedAtPause = 0L;
            this.mPaused = false;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            if (this.mPaused && this.mElapsedAtPause == 0) {
                this.mElapsedAtPause = j - getStartTime();
            }
            if (this.mPaused) {
                setStartTime(j - this.mElapsedAtPause);
            }
            return super.getTransformation(j, transformation, f);
        }

        void pause() {
            if (this.mPaused) {
                return;
            }
            this.mElapsedAtPause = 0L;
            this.mPaused = true;
        }

        void resume() {
            this.mPaused = false;
        }
    }
}
