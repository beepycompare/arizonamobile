package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
/* loaded from: classes4.dex */
final class HideRightViewOnScrollDelegate extends HideViewOnScrollDelegate {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public int getTargetTranslation() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public int getViewEdge() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public <V extends View> int getSize(V v, ViewGroup.MarginLayoutParams marginLayoutParams) {
        return v.getMeasuredWidth() + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public <V extends View> void setAdditionalHiddenOffset(V v, int i, int i2) {
        v.setTranslationX(i + i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public <V extends View> void setViewTranslation(V v, int i) {
        v.setTranslationX(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public <V extends View> ViewPropertyAnimator getViewTranslationAnimator(V v, int i) {
        return v.animate().translationX(i);
    }
}
