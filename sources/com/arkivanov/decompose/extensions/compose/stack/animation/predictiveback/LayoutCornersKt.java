package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutCorners.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"toShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorners;", "progress", "", "getProgressRadius", "Landroidx/compose/ui/unit/Dp;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;F)F", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LayoutCornersKt {
    public static final RoundedCornerShape toShape(LayoutCorners layoutCorners, float f) {
        Intrinsics.checkNotNullParameter(layoutCorners, "<this>");
        return RoundedCornerShapeKt.m1033RoundedCornerShapea9UjIt4(getProgressRadius(layoutCorners.getTopStart(), f), getProgressRadius(layoutCorners.getTopEnd(), f), getProgressRadius(layoutCorners.getBottomEnd(), f), getProgressRadius(layoutCorners.getBottomStart(), f));
    }

    private static final float getProgressRadius(LayoutCorner layoutCorner, float f) {
        boolean isFixed = layoutCorner.isFixed();
        float m8002getRadiusD9Ej5fM = layoutCorner.m8002getRadiusD9Ej5fM();
        return isFixed ? m8002getRadiusD9Ej5fM : Dp.m6684constructorimpl(m8002getRadiusD9Ej5fM * f);
    }
}
