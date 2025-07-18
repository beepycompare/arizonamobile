package androidx.compose.material3;

import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ:\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J:\u0010!\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010 R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonDefaults;", "", "()V", "LargeIconSize", "Landroidx/compose/ui/unit/Dp;", "getLargeIconSize-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "extendedFabShape", "Landroidx/compose/ui/graphics/Shape;", "getExtendedFabShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "largeShape", "getLargeShape", "shape", "getShape", "smallShape", "getSmallShape", "bottomAppBarFabElevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "bottomAppBarFabElevation-a9UjIt4", "(FFFF)Landroidx/compose/material3/FloatingActionButtonElevation;", "elevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/FloatingActionButtonElevation;", "loweredElevation", "loweredElevation-xZ9-QkE", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();
    private static final float LargeIconSize = FabPrimaryLargeTokens.INSTANCE.m2998getIconSizeD9Ej5fM();

    private FloatingActionButtonDefaults() {
    }

    /* renamed from: getLargeIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1922getLargeIconSizeD9Ej5fM() {
        return LargeIconSize;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -53247565, "C410@19302L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-53247565, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-shape> (FloatingActionButton.kt:410)");
        }
        Shape value = ShapesKt.getValue(FabPrimaryTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 394933381, "C414@19461L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394933381, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallShape> (FloatingActionButton.kt:414)");
        }
        Shape value = ShapesKt.getValue(FabPrimarySmallTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1835912187, "C418@19620L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1835912187, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeShape> (FloatingActionButton.kt:418)");
        }
        Shape value = ShapesKt.getValue(FabPrimaryLargeTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtendedFabShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -536021915, "C422@19792L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-536021915, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-extendedFabShape> (FloatingActionButton.kt:422)");
        }
        Shape value = ShapesKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1855656391, "C426@19954L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1855656391, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-containerColor> (FloatingActionButton.kt:426)");
        }
        long value = ColorSchemeKt.getValue(FabPrimaryTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* renamed from: elevation-xZ9-QkE  reason: not valid java name */
    public final FloatingActionButtonElevation m1921elevationxZ9QkE(float f, float f2, float f3, float f4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -241106249, "C(elevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp,2:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FabPrimaryTokens.INSTANCE.m3015getContainerElevationD9Ej5fM();
        }
        float f5 = f;
        if ((i2 & 2) != 0) {
            f2 = FabPrimaryTokens.INSTANCE.m3025getPressedContainerElevationD9Ej5fM();
        }
        float f6 = f2;
        if ((i2 & 4) != 0) {
            f3 = FabPrimaryTokens.INSTANCE.m3018getFocusContainerElevationD9Ej5fM();
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = FabPrimaryTokens.INSTANCE.m3019getHoverContainerElevationD9Ej5fM();
        }
        float f8 = f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-241106249, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:446)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f5, f6, f7, f8, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return floatingActionButtonElevation;
    }

    /* renamed from: loweredElevation-xZ9-QkE  reason: not valid java name */
    public final FloatingActionButtonElevation m1923loweredElevationxZ9QkE(float f, float f2, float f3, float f4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -285065125, "C(loweredElevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp,2:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FabPrimaryTokens.INSTANCE.m3021getLoweredContainerElevationD9Ej5fM();
        }
        float f5 = f;
        if ((i2 & 2) != 0) {
            f2 = FabPrimaryTokens.INSTANCE.m3024getLoweredPressedContainerElevationD9Ej5fM();
        }
        float f6 = f2;
        if ((i2 & 4) != 0) {
            f3 = FabPrimaryTokens.INSTANCE.m3022getLoweredFocusContainerElevationD9Ej5fM();
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = FabPrimaryTokens.INSTANCE.m3023getLoweredHoverContainerElevationD9Ej5fM();
        }
        float f8 = f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-285065125, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.loweredElevation (FloatingActionButton.kt:470)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f5, f6, f7, f8, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return floatingActionButtonElevation;
    }

    /* renamed from: bottomAppBarFabElevation-a9UjIt4  reason: not valid java name */
    public final FloatingActionButtonElevation m1920bottomAppBarFabElevationa9UjIt4(float f, float f2, float f3, float f4) {
        return new FloatingActionButtonElevation(f, f2, f3, f4, null);
    }

    /* renamed from: bottomAppBarFabElevation-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ FloatingActionButtonElevation m1919bottomAppBarFabElevationa9UjIt4$default(FloatingActionButtonDefaults floatingActionButtonDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m6684constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m6684constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m6684constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m6684constructorimpl(0);
        }
        return floatingActionButtonDefaults.m1920bottomAppBarFabElevationa9UjIt4(f, f2, f3, f4);
    }
}
