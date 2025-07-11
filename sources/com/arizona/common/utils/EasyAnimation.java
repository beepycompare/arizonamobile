package com.arizona.common.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EasyAnimation.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nJ@\u0010\f\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¨\u0006\u0010"}, d2 = {"Lcom/arizona/common/utils/EasyAnimation;", "", "<init>", "()V", "animateClick", "", "Landroid/view/View;", TypedValues.TransitionType.S_DURATION, "", "withStartAction", "Lkotlin/Function0;", "withEndAction", "slideWithFade", "direction", "Lcom/arizona/common/utils/EasyAnimation$SlideDirection;", "SlideDirection", "CommonLibs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EasyAnimation {
    public static final EasyAnimation INSTANCE = new EasyAnimation();

    /* compiled from: EasyAnimation.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SlideDirection.values().length];
            try {
                iArr[SlideDirection.TOP_TO_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SlideDirection.BOTTOM_TO_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SlideDirection.LEFT_TO_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SlideDirection.RIGHT_TO_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SlideDirection.OUT_SCREEN_DOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SlideDirection.OUT_SCREEN_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SlideDirection.OUT_SCREEN_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SlideDirection.OUT_SCREEN_UP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SlideDirection.SCREEN_TO_DEFAULT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private EasyAnimation() {
    }

    public static /* synthetic */ void animateClick$default(EasyAnimation easyAnimation, View view, long j, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 100;
        }
        easyAnimation.animateClick(view, j, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : function02);
    }

    public final void animateClick(View view, long j, final Function0<Unit> function0, final Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(j);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.arizona.common.utils.EasyAnimation$animateClick$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Function0<Unit> function03 = function0;
                if (function03 != null) {
                    function03.invoke();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Function0<Unit> function03 = function02;
                if (function03 != null) {
                    function03.invoke();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.arizona.common.utils.EasyAnimation$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EasyAnimation.animateClick$lambda$0(scaleAnimation, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateClick$lambda$0(ScaleAnimation scaleAnimation, View view) {
        view.startAnimation(scaleAnimation);
    }

    public static /* synthetic */ void slideWithFade$default(EasyAnimation easyAnimation, View view, SlideDirection slideDirection, long j, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        easyAnimation.slideWithFade(view, slideDirection, j, (i & 4) != 0 ? null : function0, (i & 8) != 0 ? null : function02);
    }

    public final void slideWithFade(View view, SlideDirection direction, long j, final Function0<Unit> function0, final Function0<Unit> function02) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        switch (WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1:
                ofFloat = ObjectAnimator.ofFloat(view, "translationY", -view.getHeight(), 0.0f);
                break;
            case 2:
                ofFloat = ObjectAnimator.ofFloat(view, "translationY", view.getHeight(), 0.0f);
                break;
            case 3:
                ofFloat = ObjectAnimator.ofFloat(view, "translationX", -view.getWidth(), 0.0f);
                break;
            case 4:
                ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getWidth(), 0.0f);
                break;
            case 5:
                ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, view.getHeight());
                break;
            case 6:
                ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -view.getWidth());
                break;
            case 7:
                ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getWidth());
                break;
            case 8:
                ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -view.getHeight());
                break;
            case 9:
                ofFloat = ObjectAnimator.ofFloat(view, "translationY", view.getHeight(), 0.0f);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (SetsKt.setOf((Object[]) new SlideDirection[]{SlideDirection.OUT_SCREEN_DOWN, SlideDirection.OUT_SCREEN_LEFT, SlideDirection.OUT_SCREEN_RIGHT, SlideDirection.OUT_SCREEN_UP}).contains(direction)) {
            ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        } else {
            ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(j);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.arizona.common.utils.EasyAnimation$slideWithFade$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function0<Unit> function03 = function0;
                if (function03 != null) {
                    function03.invoke();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function0<Unit> function03 = function02;
                if (function03 != null) {
                    function03.invoke();
                }
            }
        });
        animatorSet.start();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EasyAnimation.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/arizona/common/utils/EasyAnimation$SlideDirection;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_TO_BOTTOM", "BOTTOM_TO_TOP", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "OUT_SCREEN_DOWN", "OUT_SCREEN_LEFT", "OUT_SCREEN_RIGHT", "OUT_SCREEN_UP", "SCREEN_TO_DEFAULT", "CommonLibs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SlideDirection {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SlideDirection[] $VALUES;
        public static final SlideDirection TOP_TO_BOTTOM = new SlideDirection("TOP_TO_BOTTOM", 0);
        public static final SlideDirection BOTTOM_TO_TOP = new SlideDirection("BOTTOM_TO_TOP", 1);
        public static final SlideDirection LEFT_TO_RIGHT = new SlideDirection("LEFT_TO_RIGHT", 2);
        public static final SlideDirection RIGHT_TO_LEFT = new SlideDirection("RIGHT_TO_LEFT", 3);
        public static final SlideDirection OUT_SCREEN_DOWN = new SlideDirection("OUT_SCREEN_DOWN", 4);
        public static final SlideDirection OUT_SCREEN_LEFT = new SlideDirection("OUT_SCREEN_LEFT", 5);
        public static final SlideDirection OUT_SCREEN_RIGHT = new SlideDirection("OUT_SCREEN_RIGHT", 6);
        public static final SlideDirection OUT_SCREEN_UP = new SlideDirection("OUT_SCREEN_UP", 7);
        public static final SlideDirection SCREEN_TO_DEFAULT = new SlideDirection("SCREEN_TO_DEFAULT", 8);

        private static final /* synthetic */ SlideDirection[] $values() {
            return new SlideDirection[]{TOP_TO_BOTTOM, BOTTOM_TO_TOP, LEFT_TO_RIGHT, RIGHT_TO_LEFT, OUT_SCREEN_DOWN, OUT_SCREEN_LEFT, OUT_SCREEN_RIGHT, OUT_SCREEN_UP, SCREEN_TO_DEFAULT};
        }

        public static EnumEntries<SlideDirection> getEntries() {
            return $ENTRIES;
        }

        public static SlideDirection valueOf(String str) {
            return (SlideDirection) Enum.valueOf(SlideDirection.class, str);
        }

        public static SlideDirection[] values() {
            return (SlideDirection[]) $VALUES.clone();
        }

        private SlideDirection(String str, int i) {
        }

        static {
            SlideDirection[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
