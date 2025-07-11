package com.miami.game.core.design.system.theme;

import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Shape.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/design/system/theme/DialogCloseButtonShape;", "Landroidx/compose/ui/graphics/Shape;", "<init>", "()V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "design-system_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DialogCloseButtonShape implements Shape {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI */
    public Outline mo303createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path path$default = PathParser.toPath$default(new PathParser().parsePathString("M153.1,94.82L155.77,22.82C156.24,10.35,146.26,0,133.79,0H25.12C13.29,0,3.58,9.36,3.14,21.18L0.47,93.18C0,105.65,9.98,116,22.45,116H131.12C142.95,116,152.66,106.64,153.1,94.82Z"), null, 1, null);
        float[] m4309constructorimpl$default = Matrix.m4309constructorimpl$default(null, 1, null);
        Matrix.m4325scaleimpl$default(m4309constructorimpl$default, Float.intBitsToFloat((int) (j >> 32)) / 157, Float.intBitsToFloat((int) (j & 4294967295L)) / ((float) AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID), 0.0f, 4, null);
        path$default.mo3972transform58bKbWc(m4309constructorimpl$default);
        return new Outline.Generic(path$default);
    }
}
