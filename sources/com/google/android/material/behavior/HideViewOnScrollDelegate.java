package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
/* loaded from: classes4.dex */
abstract class HideViewOnScrollDelegate {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <V extends View> int getSize(V v, ViewGroup.MarginLayoutParams marginLayoutParams);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getTargetTranslation();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getViewEdge();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <V extends View> ViewPropertyAnimator getViewTranslationAnimator(V v, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <V extends View> void setAdditionalHiddenOffset(V v, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <V extends View> void setViewTranslation(V v, int i);
}
