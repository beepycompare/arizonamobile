package com.miami.game.core.design.system.theme;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Shape.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/miami/game/core/design/system/theme/RoundedParallelogramShape;", "Landroidx/compose/ui/graphics/Shape;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "skewX", "", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "design-system_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoundedParallelogramShape implements Shape {
    public static final int $stable = 0;
    private final float cornerRadius;
    private final float skewX;

    public /* synthetic */ RoundedParallelogramShape(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    private RoundedParallelogramShape(float f, float f2) {
        this.cornerRadius = f;
        this.skewX = f2;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI */
    public Outline mo303createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float mo389toPx0680j_4 = density.mo389toPx0680j_4(this.cornerRadius);
        float intBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L)) * this.skewX;
        Path Path = AndroidPath_androidKt.Path();
        Path.reset();
        long m3829constructorimpl = Offset.m3829constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        long m3829constructorimpl2 = Offset.m3829constructorimpl((Float.floatToRawIntBits(0.0f) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) << 32));
        long m3829constructorimpl3 = Offset.m3829constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat(i2) - intBitsToFloat) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat(i)) & 4294967295L));
        long m3829constructorimpl4 = Offset.m3829constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat(i)) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
        int i3 = (int) (m3829constructorimpl >> 32);
        int i4 = (int) (m3829constructorimpl & 4294967295L);
        Path.moveTo(Float.intBitsToFloat(i3) + mo389toPx0680j_4, Float.intBitsToFloat(i4));
        int i5 = (int) (m3829constructorimpl2 >> 32);
        int i6 = (int) (m3829constructorimpl2 & 4294967295L);
        Path.lineTo(Float.intBitsToFloat(i5) - mo389toPx0680j_4, Float.intBitsToFloat(i6));
        float f = 2 * mo389toPx0680j_4;
        Path.arcTo(new Rect(Float.intBitsToFloat(i5) - f, Float.intBitsToFloat(i6), Float.intBitsToFloat(i5), Float.intBitsToFloat(i6) + f), -90.0f, 90.0f, false);
        int i7 = (int) (m3829constructorimpl3 >> 32);
        int i8 = (int) (m3829constructorimpl3 & 4294967295L);
        Path.lineTo(Float.intBitsToFloat(i7), Float.intBitsToFloat(i8) - mo389toPx0680j_4);
        Path.arcTo(new Rect(Float.intBitsToFloat(i7) - f, Float.intBitsToFloat(i8) - f, Float.intBitsToFloat(i7), Float.intBitsToFloat(i8)), 0.0f, 90.0f, false);
        int i9 = (int) (m3829constructorimpl4 >> 32);
        int i10 = (int) (m3829constructorimpl4 & 4294967295L);
        Path.lineTo(Float.intBitsToFloat(i9) + mo389toPx0680j_4, Float.intBitsToFloat(i10));
        Path.arcTo(new Rect(Float.intBitsToFloat(i9), Float.intBitsToFloat(i10) - f, Float.intBitsToFloat(i9) + f, Float.intBitsToFloat(i10)), 90.0f, 90.0f, false);
        Path.lineTo(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4) + mo389toPx0680j_4);
        Path.arcTo(new Rect(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4), Float.intBitsToFloat(i3) + f, Float.intBitsToFloat(i4) + f), 180.0f, 90.0f, false);
        Path.close();
        return new Outline.Generic(Path);
    }

    public /* synthetic */ RoundedParallelogramShape(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.m6684constructorimpl(8) : f, (i & 2) != 0 ? 0.05f : f2, null);
    }
}
