package androidx.dynamicanimation.animation;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import androidx.dynamicanimation.animation.AnimationHandler;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AnimationHandler {
    private static final ThreadLocal<AnimationHandler> sAnimatorHandler = new ThreadLocal<>();
    public DurationScaleChangeListener mDurationScaleChangeListener;
    private FrameCallbackScheduler mScheduler;
    private final SimpleArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime = new SimpleArrayMap<>();
    final ArrayList<AnimationFrameCallback> mAnimationCallbacks = new ArrayList<>();
    private final AnimationCallbackDispatcher mCallbackDispatcher = new AnimationCallbackDispatcher();
    private final Runnable mRunnable = new Runnable() { // from class: androidx.dynamicanimation.animation.AnimationHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            AnimationHandler.this.m8735x83fff5a8();
        }
    };
    long mCurrentFrameTime = 0;
    private boolean mListDirty = false;
    public float mDurationScale = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long j);
    }

    /* loaded from: classes2.dex */
    public interface DurationScaleChangeListener {
        boolean register();

        boolean unregister();
    }

    /* loaded from: classes2.dex */
    private class AnimationCallbackDispatcher {
        private AnimationCallbackDispatcher() {
        }

        void dispatchAnimationFrame() {
            AnimationHandler.this.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.doAnimationFrame(animationHandler.mCurrentFrameTime);
            if (AnimationHandler.this.mAnimationCallbacks.size() > 0) {
                AnimationHandler.this.mScheduler.postFrameCallback(AnimationHandler.this.mRunnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$androidx-dynamicanimation-animation-AnimationHandler  reason: not valid java name */
    public /* synthetic */ void m8735x83fff5a8() {
        this.mCallbackDispatcher.dispatchAnimationFrame();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler(new FrameCallbackScheduler16()));
        }
        return threadLocal.get();
    }

    public AnimationHandler(FrameCallbackScheduler frameCallbackScheduler) {
        this.mScheduler = frameCallbackScheduler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAnimationFrameCallback(AnimationFrameCallback animationFrameCallback, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            this.mScheduler.postFrameCallback(this.mRunnable);
            if (Build.VERSION.SDK_INT >= 33) {
                this.mDurationScale = ValueAnimator.getDurationScale();
                if (this.mDurationScaleChangeListener == null) {
                    this.mDurationScaleChangeListener = new DurationScaleChangeListener33();
                }
                this.mDurationScaleChangeListener.register();
            }
        }
        if (!this.mAnimationCallbacks.contains(animationFrameCallback)) {
            this.mAnimationCallbacks.add(animationFrameCallback);
        }
        if (j > 0) {
            this.mDelayedCallbackStartTime.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCallback(AnimationFrameCallback animationFrameCallback) {
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        int indexOf = this.mAnimationCallbacks.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.mListDirty = true;
        }
    }

    void doAnimationFrame(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.mAnimationCallbacks.size(); i++) {
            AnimationFrameCallback animationFrameCallback = this.mAnimationCallbacks.get(i);
            if (animationFrameCallback != null && isCallbackDue(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.doAnimationFrame(j);
            }
        }
        cleanUpList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCurrentThread() {
        return this.mScheduler.isCurrentThread();
    }

    private boolean isCallbackDue(AnimationFrameCallback animationFrameCallback, long j) {
        Long l = this.mDelayedCallbackStartTime.get(animationFrameCallback);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.mDelayedCallbackStartTime.remove(animationFrameCallback);
            return true;
        }
        return false;
    }

    private void cleanUpList() {
        ArrayList<AnimationFrameCallback> arrayList;
        if (this.mListDirty) {
            int size = this.mAnimationCallbacks.size();
            while (true) {
                size--;
                arrayList = this.mAnimationCallbacks;
                if (size < 0) {
                    break;
                } else if (arrayList.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            if (arrayList.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                this.mDurationScaleChangeListener.unregister();
            }
            this.mListDirty = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameCallbackScheduler getScheduler() {
        return this.mScheduler;
    }

    /* loaded from: classes2.dex */
    static final class FrameCallbackScheduler16 implements FrameCallbackScheduler {
        private final Choreographer mChoreographer = Choreographer.getInstance();
        private final Looper mLooper = Looper.myLooper();

        FrameCallbackScheduler16() {
        }

        @Override // androidx.dynamicanimation.animation.FrameCallbackScheduler
        public void postFrameCallback(final Runnable runnable) {
            this.mChoreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackScheduler16$$ExternalSyntheticLambda0
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    runnable.run();
                }
            });
        }

        @Override // androidx.dynamicanimation.animation.FrameCallbackScheduler
        public boolean isCurrentThread() {
            return Thread.currentThread() == this.mLooper.getThread();
        }
    }

    public float getDurationScale() {
        return this.mDurationScale;
    }

    /* loaded from: classes2.dex */
    public class DurationScaleChangeListener33 implements DurationScaleChangeListener {
        ValueAnimator.DurationScaleChangeListener mListener;

        public DurationScaleChangeListener33() {
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.DurationScaleChangeListener
        public boolean register() {
            if (this.mListener == null) {
                ValueAnimator.DurationScaleChangeListener durationScaleChangeListener = new ValueAnimator.DurationScaleChangeListener() { // from class: androidx.dynamicanimation.animation.AnimationHandler$DurationScaleChangeListener33$$ExternalSyntheticLambda0
                    public final void onChanged(float f) {
                        AnimationHandler.DurationScaleChangeListener33.this.m8736xb804c881(f);
                    }
                };
                this.mListener = durationScaleChangeListener;
                return ValueAnimator.registerDurationScaleChangeListener(durationScaleChangeListener);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$register$0$androidx-dynamicanimation-animation-AnimationHandler$DurationScaleChangeListener33  reason: not valid java name */
        public /* synthetic */ void m8736xb804c881(float f) {
            AnimationHandler.this.mDurationScale = f;
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.DurationScaleChangeListener
        public boolean unregister() {
            boolean unregisterDurationScaleChangeListener = ValueAnimator.unregisterDurationScaleChangeListener(this.mListener);
            this.mListener = null;
            return unregisterDurationScaleChangeListener;
        }
    }
}
