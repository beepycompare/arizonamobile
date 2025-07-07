package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import android.content.Context;
import android.view.View;
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
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayoutCorners.android.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LayoutCorners_androidKt$withLayoutCorners$1 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function2<Modifier, LayoutCorners, Modifier> $block;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public LayoutCorners_androidKt$withLayoutCorners$1(Function2<? super Modifier, ? super LayoutCorners, ? extends Modifier> function2) {
        this.$block = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier composed, Composer composer, int i) {
        Modifier invoke;
        LayoutCorners layoutCorners;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(400376964);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(400376964, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.withLayoutCorners.<anonymous> (LayoutCorners.android.kt:26)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume2;
        composer.startReplaceGroup(-564715838);
        boolean changed = composer.changed(context);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = LayoutCorners_androidKt.getScreenInfo(context, density);
            composer.updateRememberedValue(rememberedValue);
        }
        ScreenInfo screenInfo = (ScreenInfo) rememberedValue;
        composer.endReplaceGroup();
        if (screenInfo == null) {
            invoke = this.$block.invoke(composed, new LayoutCorners(null, null, null, null, 15, null));
        } else {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(composer);
            final View view = (View) consume3;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume4 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume4;
            composer.startReplaceGroup(-564708426);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            composer.endReplaceGroup();
            layoutCorners = LayoutCorners_androidKt.getLayoutCorners(screenInfo, invoke$lambda$2(mutableState), layoutDirection);
            Function2<Modifier, LayoutCorners, Modifier> function2 = this.$block;
            composer.startReplaceGroup(-564703049);
            boolean changedInstance = composer.changedInstance(view);
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners_androidKt$withLayoutCorners$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$5$lambda$4;
                        invoke$lambda$5$lambda$4 = LayoutCorners_androidKt$withLayoutCorners$1.invoke$lambda$5$lambda$4(view, mutableState, (LayoutCoordinates) obj);
                        return invoke$lambda$5$lambda$4;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            invoke = function2.invoke(OnGloballyPositionedModifierKt.onGloballyPositioned(composed, (Function1) rememberedValue3), layoutCorners);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return invoke;
    }

    private static final Rect invoke$lambda$2(MutableState<Rect> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(View view, MutableState mutableState, LayoutCoordinates coords) {
        Rect boundsOnScreen;
        Intrinsics.checkNotNullParameter(coords, "coords");
        boundsOnScreen = LayoutCorners_androidKt.getBoundsOnScreen(view, LayoutCoordinatesKt.boundsInRoot(coords));
        mutableState.setValue(boundsOnScreen);
        return Unit.INSTANCE;
    }
}
