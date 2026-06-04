package com.miami.game.feature.select.server.ui.compose;

import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Shape.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rÊ\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/miami/game/feature/select/server/ui/compose/ExpShape;", "Landroidx/compose/ui/graphics/Shape;", "<init>", "()V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "select-server", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpShape implements Shape {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI */
    public Outline mo344createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path path$default = PathParser.toPath$default(new PathParser().parsePathString("M 11.3133 60.7005 L 1.081 28.7005 C -3.4579 14.5056 7.1329 0 22.0358 0 H 188.539 C 198.108 0 206.579 6.1851 209.494 15.2993 L 219.726 47.2993 C 224.265 61.4942 213.674 76 198.771 76 H 32.2681 C 22.6993 76 14.2277 69.8148 11.3133 60.7005 Z"), null, 1, null);
        float[] m5592constructorimpl$default = Matrix.m5592constructorimpl$default(null, 1, null);
        Matrix.m5608scaleimpl$default(m5592constructorimpl$default, Float.intBitsToFloat((int) (j >> 32)) / 237.0f, Float.intBitsToFloat((int) (j & 4294967295L)) / 76.0f, 0.0f, 4, null);
        path$default.mo5239transform58bKbWc(m5592constructorimpl$default);
        return new Outline.Generic(path$default);
    }
}
