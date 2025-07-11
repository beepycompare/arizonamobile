package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import android.content.Context;
import android.os.Build;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutCorners.android.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0000\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001f\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0002\b\u0017\u001a\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002¨\u0006\u001c²\u0006\f\u0010\r\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002"}, d2 = {"withLayoutCorners", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function2;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorners;", "Lkotlin/ExtensionFunctionType;", "getScreenInfo", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/ScreenInfo;", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "getLayoutCorners", "screenInfo", "positionOnScreen", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutCorner", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;", "radius", "Landroidx/compose/ui/unit/Dp;", "isFixed", "", "getLayoutCorner-_Y4kl1M", "getBoundsOnScreen", "rootView", "Landroid/view/View;", "boundsInRoot", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LayoutCorners_androidKt {

    /* compiled from: LayoutCorners.android.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Modifier withLayoutCorners(Modifier modifier, Function2<? super Modifier, ? super LayoutCorners, ? extends Modifier> block) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return ComposedModifierKt.composed$default(modifier, null, new LayoutCorners_androidKt$withLayoutCorners$1(block), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScreenInfo getScreenInfo(Context context, Density density) {
        WindowManager windowManager;
        WindowMetrics maximumWindowMetrics;
        if (Build.VERSION.SDK_INT < 31 || (windowManager = (WindowManager) context.getSystemService(WindowManager.class)) == null || (maximumWindowMetrics = windowManager.getMaximumWindowMetrics()) == null) {
            return null;
        }
        WindowInsets windowInsets = maximumWindowMetrics.getWindowInsets();
        Intrinsics.checkNotNullExpressionValue(windowInsets, "getWindowInsets(...)");
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(0);
        Dp m6682boximpl = roundedCorner != null ? Dp.m6682boximpl(density.mo386toDpu2uoSUM(roundedCorner.getRadius())) : null;
        RoundedCorner roundedCorner2 = windowInsets.getRoundedCorner(1);
        Dp m6682boximpl2 = roundedCorner2 != null ? Dp.m6682boximpl(density.mo386toDpu2uoSUM(roundedCorner2.getRadius())) : null;
        RoundedCorner roundedCorner3 = windowInsets.getRoundedCorner(2);
        Dp m6682boximpl3 = roundedCorner3 != null ? Dp.m6682boximpl(density.mo386toDpu2uoSUM(roundedCorner3.getRadius())) : null;
        RoundedCorner roundedCorner4 = windowInsets.getRoundedCorner(3);
        return new ScreenInfo(new CornerRadii(m6682boximpl, m6682boximpl2, m6682boximpl3, roundedCorner4 != null ? Dp.m6682boximpl(density.mo386toDpu2uoSUM(roundedCorner4.getRadius())) : null, null), maximumWindowMetrics.getBounds().width(), maximumWindowMetrics.getBounds().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCorners getLayoutCorners(ScreenInfo screenInfo, Rect rect, LayoutDirection layoutDirection) {
        if (rect == null) {
            return new LayoutCorners(null, null, null, null, 15, null);
        }
        CornerRadii component1 = screenInfo.component1();
        int component2 = screenInfo.component2();
        int component3 = screenInfo.component3();
        float component12 = rect.component1();
        float component22 = rect.component2();
        float component32 = rect.component3();
        float component4 = rect.component4();
        int i = (component12 > 0.0f ? 1 : (component12 == 0.0f ? 0 : -1));
        boolean z = false;
        LayoutCorner m8003getLayoutCorner_Y4kl1M = m8003getLayoutCorner_Y4kl1M(component1.m7997getTopLeftlTKBWiU(), i <= 0 && component22 <= 0.0f);
        int i2 = (component32 > component2 ? 1 : (component32 == component2 ? 0 : -1));
        LayoutCorner m8003getLayoutCorner_Y4kl1M2 = m8003getLayoutCorner_Y4kl1M(component1.m7998getTopRightlTKBWiU(), i2 >= 0 && component22 <= 0.0f);
        LayoutCorner m8003getLayoutCorner_Y4kl1M3 = m8003getLayoutCorner_Y4kl1M(component1.m7996getBottomRightlTKBWiU(), i2 >= 0 && component4 >= ((float) component3));
        Dp m7995getBottomLeftlTKBWiU = component1.m7995getBottomLeftlTKBWiU();
        if (i <= 0 && component4 >= component3) {
            z = true;
        }
        LayoutCorner m8003getLayoutCorner_Y4kl1M4 = m8003getLayoutCorner_Y4kl1M(m7995getBottomLeftlTKBWiU, z);
        int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return new LayoutCorners(m8003getLayoutCorner_Y4kl1M2, m8003getLayoutCorner_Y4kl1M, m8003getLayoutCorner_Y4kl1M4, m8003getLayoutCorner_Y4kl1M3);
        }
        return new LayoutCorners(m8003getLayoutCorner_Y4kl1M, m8003getLayoutCorner_Y4kl1M2, m8003getLayoutCorner_Y4kl1M3, m8003getLayoutCorner_Y4kl1M4);
    }

    /* renamed from: getLayoutCorner-_Y4kl1M  reason: not valid java name */
    private static final LayoutCorner m8003getLayoutCorner_Y4kl1M(Dp dp, boolean z) {
        if (dp == null) {
            return new LayoutCorner(0.0f, false, 3, null);
        }
        return new LayoutCorner(dp.m6698unboximpl(), z, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getBoundsOnScreen(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float f = iArr[0];
        float f2 = iArr[1];
        return new Rect(rect.getLeft() + f, rect.getTop() + f2, f + rect.getRight(), f2 + rect.getBottom());
    }
}
