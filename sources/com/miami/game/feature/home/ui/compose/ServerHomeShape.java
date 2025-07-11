package com.miami.game.feature.home.ui.compose;

import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlayContent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/miami/game/feature/home/ui/compose/ServerHomeShape;", "Landroidx/compose/ui/graphics/Shape;", "<init>", "()V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerHomeShape implements Shape {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI */
    public Outline mo303createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path path$default = PathParser.toPath$default(new PathParser().parsePathString("M 0.5768 25.1032 C -1.3113 11.8522 8.972 0 22.3568 0 H 500.912 C 511.864 0 521.148 8.0548 522.692 18.8967 L 529.423 66.1361 C 531.311 79.387 521.028 91.239 507.643 91.239 H 29.0876 C 18.1362 91.239 8.8523 83.184 7.3075 72.343 L 0.5768 25.1032 Z"), null, 1, null);
        float[] m4309constructorimpl$default = Matrix.m4309constructorimpl$default(null, 1, null);
        Matrix.m4325scaleimpl$default(m4309constructorimpl$default, Float.intBitsToFloat((int) (j >> 32)) / 536, Float.intBitsToFloat((int) (j & 4294967295L)) / 92, 0.0f, 4, null);
        path$default.mo3972transform58bKbWc(m4309constructorimpl$default);
        return new Outline.Generic(path$default);
    }
}
