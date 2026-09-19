package ru.mrlargha.commonui.elements.donate.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ImageFader.kt */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/donate/utils/ImageFader;", "", "imageView", "Landroid/widget/ImageView;", "images", "", "", TypedValues.TransitionType.S_DURATION, "", "delay", "<init>", "(Landroid/widget/ImageView;Ljava/util/List;JJ)V", "currentIndex", "isRunning", "", "animationGeneration", "activeAnimators", "", "Landroid/animation/Animator;", "handler", "Landroid/os/Handler;", "runnable", "ru/mrlargha/commonui/elements/donate/utils/ImageFader$runnable$1", "Lru/mrlargha/commonui/elements/donate/utils/ImageFader$runnable$1;", TtmlNode.START, "", "stop", "crossfade", "newResId", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ImageFader {
    private final Set<Animator> activeAnimators;
    private long animationGeneration;
    private int currentIndex;
    private final long delay;
    private final long duration;
    private final Handler handler;
    private final ImageView imageView;
    private final List<Integer> images;
    private boolean isRunning;
    private final ImageFader$runnable$1 runnable;

    /* JADX WARN: Type inference failed for: r2v4, types: [ru.mrlargha.commonui.elements.donate.utils.ImageFader$runnable$1] */
    public ImageFader(ImageView imageView, List<Integer> images, long j, long j2) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(images, "images");
        this.imageView = imageView;
        this.images = images;
        this.duration = j;
        this.delay = j2;
        this.activeAnimators = new LinkedHashSet();
        this.handler = new Handler(Looper.getMainLooper());
        this.runnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.utils.ImageFader$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                int i;
                List list;
                List list2;
                Handler handler;
                long j3;
                long j4;
                z = ImageFader.this.isRunning;
                if (z) {
                    i = ImageFader.this.currentIndex;
                    list = ImageFader.this.images;
                    int size = (i + 1) % list.size();
                    ImageFader imageFader = ImageFader.this;
                    list2 = imageFader.images;
                    imageFader.crossfade(((Number) list2.get(size)).intValue());
                    ImageFader.this.currentIndex = size;
                    handler = ImageFader.this.handler;
                    j3 = ImageFader.this.delay;
                    j4 = ImageFader.this.duration;
                    handler.postDelayed(this, j3 + j4);
                }
            }
        };
    }

    public /* synthetic */ ImageFader(ImageView imageView, List list, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageView, list, (i & 4) != 0 ? 1500L : j, (i & 8) != 0 ? 0L : j2);
    }

    public final void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.animationGeneration++;
        this.handler.post(this.runnable);
    }

    public final void stop() {
        this.isRunning = false;
        this.handler.removeCallbacks(this.runnable);
        this.animationGeneration++;
        List<Animator> list = CollectionsKt.toList(this.activeAnimators);
        this.activeAnimators.clear();
        for (Animator animator : list) {
            animator.removeAllListeners();
            animator.cancel();
        }
        this.imageView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void crossfade(final int i) {
        final long j = this.animationGeneration;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.imageView, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(this.duration);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: ru.mrlargha.commonui.elements.donate.utils.ImageFader$crossfade$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Set set;
                boolean z;
                long j2;
                ImageView imageView;
                ImageView imageView2;
                long j3;
                Set set2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                set = ImageFader.this.activeAnimators;
                set.remove(animation);
                z = ImageFader.this.isRunning;
                if (z) {
                    long j4 = j;
                    j2 = ImageFader.this.animationGeneration;
                    if (j4 != j2) {
                        return;
                    }
                    imageView = ImageFader.this.imageView;
                    imageView.setImageResource(i);
                    imageView2 = ImageFader.this.imageView;
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "alpha", 0.0f, 1.0f);
                    j3 = ImageFader.this.duration;
                    ofFloat2.setDuration(j3);
                    final ImageFader imageFader = ImageFader.this;
                    final long j5 = j;
                    ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: ru.mrlargha.commonui.elements.donate.utils.ImageFader$crossfade$1$onAnimationEnd$1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation2) {
                            Set set3;
                            boolean z2;
                            long unused;
                            Intrinsics.checkNotNullParameter(animation2, "animation");
                            set3 = ImageFader.this.activeAnimators;
                            set3.remove(animation2);
                            z2 = ImageFader.this.isRunning;
                            if (z2) {
                                unused = ImageFader.this.animationGeneration;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation2) {
                            Set set3;
                            Intrinsics.checkNotNullParameter(animation2, "animation");
                            set3 = ImageFader.this.activeAnimators;
                            set3.remove(animation2);
                        }
                    });
                    set2 = ImageFader.this.activeAnimators;
                    Intrinsics.checkNotNull(ofFloat2);
                    set2.add(ofFloat2);
                    ofFloat2.start();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Set set;
                Intrinsics.checkNotNullParameter(animation, "animation");
                set = ImageFader.this.activeAnimators;
                set.remove(animation);
            }
        });
        Set<Animator> set = this.activeAnimators;
        Intrinsics.checkNotNull(ofFloat);
        set.add(ofFloat);
        ofFloat.start();
    }
}
