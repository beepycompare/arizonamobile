package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import android.content.Context;
import android.os.Build;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutCorners.android.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001f\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\b\u0019\u001a\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002¨\u0006\u001e²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u008a\u008e\u0002"}, d2 = {"withLayoutCorners", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function2;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorners;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "getScreenInfo", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/ScreenInfo;", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "getLayoutCorners", "screenInfo", "positionOnScreen", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutCorner", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;", "radius", "Landroidx/compose/ui/unit/Dp;", "isFixed", "", "getLayoutCorner-_Y4kl1M", "getBoundsOnScreen", "rootView", "Landroid/view/View;", "boundsInRoot", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutCorners_androidKt {

    /* compiled from: LayoutCorners.android.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
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

    public static final Modifier withLayoutCorners(Modifier modifier, Function4<? super Modifier, ? super LayoutCorners, ? super Composer, ? super Integer, ? extends Modifier> block, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceGroup(972114425);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(972114425, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.withLayoutCorners (LayoutCorners.android.kt:25)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume2;
        composer.startReplaceGroup(-1243583549);
        boolean changed = composer.changed(context);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = getScreenInfo(context, density);
            composer.updateRememberedValue(rememberedValue);
        }
        ScreenInfo screenInfo = (ScreenInfo) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1243581676);
        if (screenInfo == null) {
            Modifier invoke = block.invoke(modifier, new LayoutCorners(null, null, null, null, 15, null), composer, Integer.valueOf(((i << 3) & 896) | (i & 14)));
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return invoke;
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final View view = (View) consume3;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume4 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume4;
        composer.startReplaceGroup(-1243575593);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState = (MutableState) rememberedValue2;
        composer.endReplaceGroup();
        LayoutCorners layoutCorners = getLayoutCorners(screenInfo, withLayoutCorners$lambda$2(mutableState), layoutDirection);
        composer.startReplaceGroup(-1243570520);
        boolean changedInstance = composer.changedInstance(view);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LayoutCorners_androidKt.withLayoutCorners$lambda$5$lambda$4(view, mutableState, (LayoutCoordinates) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Modifier invoke2 = block.invoke(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) rememberedValue3), layoutCorners, composer, Integer.valueOf((i << 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return invoke2;
    }

    private static final Rect withLayoutCorners$lambda$2(MutableState<Rect> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit withLayoutCorners$lambda$5$lambda$4(View view, MutableState mutableState, LayoutCoordinates coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        mutableState.setValue(getBoundsOnScreen(view, LayoutCoordinatesKt.boundsInRoot(coords)));
        return Unit.INSTANCE;
    }

    private static final ScreenInfo getScreenInfo(Context context, Density density) {
        WindowManager windowManager;
        WindowMetrics maximumWindowMetrics;
        if (Build.VERSION.SDK_INT < 31 || (windowManager = (WindowManager) context.getSystemService(WindowManager.class)) == null || (maximumWindowMetrics = windowManager.getMaximumWindowMetrics()) == null) {
            return null;
        }
        WindowInsets windowInsets = maximumWindowMetrics.getWindowInsets();
        Intrinsics.checkNotNullExpressionValue(windowInsets, "getWindowInsets(...)");
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(0);
        Dp m8158boximpl = roundedCorner != null ? Dp.m8158boximpl(density.mo431toDpu2uoSUM(roundedCorner.getRadius())) : null;
        RoundedCorner roundedCorner2 = windowInsets.getRoundedCorner(1);
        Dp m8158boximpl2 = roundedCorner2 != null ? Dp.m8158boximpl(density.mo431toDpu2uoSUM(roundedCorner2.getRadius())) : null;
        RoundedCorner roundedCorner3 = windowInsets.getRoundedCorner(2);
        Dp m8158boximpl3 = roundedCorner3 != null ? Dp.m8158boximpl(density.mo431toDpu2uoSUM(roundedCorner3.getRadius())) : null;
        RoundedCorner roundedCorner4 = windowInsets.getRoundedCorner(3);
        return new ScreenInfo(new CornerRadii(m8158boximpl, m8158boximpl2, m8158boximpl3, roundedCorner4 != null ? Dp.m8158boximpl(density.mo431toDpu2uoSUM(roundedCorner4.getRadius())) : null, null), maximumWindowMetrics.getBounds().width(), maximumWindowMetrics.getBounds().height());
    }

    private static final LayoutCorners getLayoutCorners(ScreenInfo screenInfo, Rect rect, LayoutDirection layoutDirection) {
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
        LayoutCorner m9490getLayoutCorner_Y4kl1M = m9490getLayoutCorner_Y4kl1M(component1.m9484getTopLeftlTKBWiU(), i <= 0 && component22 <= 0.0f);
        int i2 = (component32 > component2 ? 1 : (component32 == component2 ? 0 : -1));
        LayoutCorner m9490getLayoutCorner_Y4kl1M2 = m9490getLayoutCorner_Y4kl1M(component1.m9485getTopRightlTKBWiU(), i2 >= 0 && component22 <= 0.0f);
        LayoutCorner m9490getLayoutCorner_Y4kl1M3 = m9490getLayoutCorner_Y4kl1M(component1.m9483getBottomRightlTKBWiU(), i2 >= 0 && component4 >= ((float) component3));
        Dp m9482getBottomLeftlTKBWiU = component1.m9482getBottomLeftlTKBWiU();
        if (i <= 0 && component4 >= component3) {
            z = true;
        }
        LayoutCorner m9490getLayoutCorner_Y4kl1M4 = m9490getLayoutCorner_Y4kl1M(m9482getBottomLeftlTKBWiU, z);
        int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return new LayoutCorners(m9490getLayoutCorner_Y4kl1M2, m9490getLayoutCorner_Y4kl1M, m9490getLayoutCorner_Y4kl1M4, m9490getLayoutCorner_Y4kl1M3);
        }
        return new LayoutCorners(m9490getLayoutCorner_Y4kl1M, m9490getLayoutCorner_Y4kl1M2, m9490getLayoutCorner_Y4kl1M3, m9490getLayoutCorner_Y4kl1M4);
    }

    /* renamed from: getLayoutCorner-_Y4kl1M  reason: not valid java name */
    private static final LayoutCorner m9490getLayoutCorner_Y4kl1M(Dp dp, boolean z) {
        if (dp == null) {
            return new LayoutCorner(0.0f, false, 3, null);
        }
        return new LayoutCorner(dp.m8174unboximpl(), z, null);
    }

    private static final Rect getBoundsOnScreen(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float f = iArr[0];
        float f2 = iArr[1];
        return new Rect(rect.getLeft() + f, rect.getTop() + f2, f + rect.getRight(), f2 + rect.getBottom());
    }
}
