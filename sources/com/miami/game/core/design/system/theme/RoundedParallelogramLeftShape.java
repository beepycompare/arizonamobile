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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/miami/game/core/design/system/theme/RoundedParallelogramLeftShape;", "Landroidx/compose/ui/graphics/Shape;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "skewX", "", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "design-system_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoundedParallelogramLeftShape implements Shape {
    public static final int $stable = 0;
    private final float cornerRadius;
    private final float skewX;

    public /* synthetic */ RoundedParallelogramLeftShape(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    private RoundedParallelogramLeftShape(float f, float f2) {
        this.cornerRadius = f;
        this.skewX = f2;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI */
    public Outline mo303createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float mo389toPx0680j_4 = density.mo389toPx0680j_4(this.cornerRadius);
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float f = this.skewX * intBitsToFloat2;
        float degrees = (float) Math.toDegrees((float) Math.atan(f / intBitsToFloat2));
        float f2 = 90.0f - degrees;
        float f3 = degrees + 90.0f;
        Path Path = AndroidPath_androidKt.Path();
        Path.reset();
        long m3829constructorimpl = Offset.m3829constructorimpl((Float.floatToRawIntBits(0.0f) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
        long m3829constructorimpl2 = Offset.m3829constructorimpl((Float.floatToRawIntBits(intBitsToFloat - f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        long m3829constructorimpl3 = Offset.m3829constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
        long m3829constructorimpl4 = Offset.m3829constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
        int i = (int) (m3829constructorimpl >> 32);
        int i2 = (int) (m3829constructorimpl & 4294967295L);
        Path.moveTo(Float.intBitsToFloat(i) + mo389toPx0680j_4, Float.intBitsToFloat(i2));
        int i3 = (int) (m3829constructorimpl2 >> 32);
        float f4 = 2 * mo389toPx0680j_4;
        int i4 = (int) (m3829constructorimpl2 & 4294967295L);
        Path.arcTo(new Rect(Float.intBitsToFloat(i3) - f4, Float.intBitsToFloat(i4), Float.intBitsToFloat(i3), Float.intBitsToFloat(i4) + f4), -90.0f, f2, false);
        int i5 = (int) (m3829constructorimpl3 >> 32);
        int i6 = (int) (m3829constructorimpl3 & 4294967295L);
        Path.arcTo(new Rect(Float.intBitsToFloat(i5) - f4, Float.intBitsToFloat(i6) - f4, Float.intBitsToFloat(i5), Float.intBitsToFloat(i6)), 0.0f - degrees, f3, false);
        int i7 = (int) (m3829constructorimpl4 >> 32);
        int i8 = (int) (m3829constructorimpl4 & 4294967295L);
        Path.arcTo(new Rect(Float.intBitsToFloat(i7), Float.intBitsToFloat(i8) - f4, Float.intBitsToFloat(i7) + f4, Float.intBitsToFloat(i8)), 90.0f, f2, false);
        Path.arcTo(new Rect(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat(i) + f4, Float.intBitsToFloat(i2) + f4), 180.0f - degrees, f3, false);
        Path.close();
        return new Outline.Generic(Path);
    }

    public /* synthetic */ RoundedParallelogramLeftShape(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.m6684constructorimpl(8) : f, (i & 2) != 0 ? 0.45f : f2, null);
    }
}
