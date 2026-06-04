package ru.mrlargha.commonui.utils.ui.GradientCard;

import android.graphics.drawable.GradientDrawable;
import com.google.android.material.card.MaterialCardView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GradientCard.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"setGradient", "", "Lcom/google/android/material/card/MaterialCardView;", "startColor", "", "endColor", "angle", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GradientCardKt {
    public static /* synthetic */ void setGradient$default(MaterialCardView materialCardView, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        setGradient(materialCardView, i, i2, i3);
    }

    public static final void setGradient(MaterialCardView materialCardView, int i, int i2, int i3) {
        GradientDrawable.Orientation orientation;
        Intrinsics.checkNotNullParameter(materialCardView, "<this>");
        if (i3 == 0) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        } else if (i3 == 45) {
            orientation = GradientDrawable.Orientation.BL_TR;
        } else if (i3 == 90) {
            orientation = GradientDrawable.Orientation.BOTTOM_TOP;
        } else if (i3 == 135) {
            orientation = GradientDrawable.Orientation.BR_TL;
        } else if (i3 == 180) {
            orientation = GradientDrawable.Orientation.RIGHT_LEFT;
        } else if (i3 == 225) {
            orientation = GradientDrawable.Orientation.TR_BL;
        } else if (i3 == 270) {
            orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        } else if (i3 == 315) {
            orientation = GradientDrawable.Orientation.TL_BR;
        } else {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{i, i2});
        gradientDrawable.setCornerRadius(materialCardView.getRadius());
        materialCardView.setBackground(gradientDrawable);
    }
}
