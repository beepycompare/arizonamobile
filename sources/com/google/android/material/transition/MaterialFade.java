package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
/* loaded from: classes4.dex */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {
    private static final float DEFAULT_FADE_END_THRESHOLD_ENTER = 0.3f;
    private static final float DEFAULT_START_SCALE = 0.8f;
    private static final int DEFAULT_THEMED_INCOMING_DURATION_ATTR = R.attr.motionDurationMedium4;
    private static final int DEFAULT_THEMED_OUTGOING_DURATION_ATTR = R.attr.motionDurationShort3;
    private static final int DEFAULT_THEMED_INCOMING_EASING_ATTR = R.attr.motionEasingEmphasizedDecelerateInterpolator;
    private static final int DEFAULT_THEMED_OUTGOING_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.material.transition.VisibilityAnimatorProvider, com.google.android.material.transition.FadeProvider] */
    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ FadeProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Transition
    public /* bridge */ /* synthetic */ boolean isSeekingSupported() {
        return super.isSeekingSupported();
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }

    public MaterialFade() {
        super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
    }

    private static FadeProvider createPrimaryAnimatorProvider() {
        FadeProvider fadeProvider = new FadeProvider();
        fadeProvider.setIncomingEndThreshold(DEFAULT_FADE_END_THRESHOLD_ENTER);
        return fadeProvider;
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.setScaleOnDisappear(false);
        scaleProvider.setIncomingStartScale(0.8f);
        return scaleProvider;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    int getDurationThemeAttrResId(boolean z) {
        if (z) {
            return DEFAULT_THEMED_INCOMING_DURATION_ATTR;
        }
        return DEFAULT_THEMED_OUTGOING_DURATION_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    int getEasingThemeAttrResId(boolean z) {
        if (z) {
            return DEFAULT_THEMED_INCOMING_EASING_ATTR;
        }
        return DEFAULT_THEMED_OUTGOING_EASING_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    TimeInterpolator getDefaultEasingInterpolator(boolean z) {
        return AnimationUtils.LINEAR_INTERPOLATOR;
    }
}
