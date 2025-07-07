package com.skydoves.cloudy;

import android.graphics.Bitmap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyModifierNode.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0002\u0010\n\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"cloudy", "Landroidx/compose/ui/Modifier;", "radius", "", "enabled", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "(Landroidx/compose/ui/Modifier;IZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "createCompatibleBitmap", "Landroid/graphics/Bitmap;", "inputBitmap", "cloudy_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CloudyModifierNodeKt {
    public static final Modifier cloudy(Modifier modifier, int i, boolean z, Function1<? super CloudyState, Unit> function1, Composer composer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        composer.startReplaceGroup(884553496);
        if ((i3 & 1) != 0) {
            i = 10;
        }
        if ((i3 & 2) != 0) {
            z = true;
        }
        if ((i3 & 4) != 0) {
            composer.startReplaceGroup(1231142919);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.skydoves.cloudy.CloudyModifierNodeKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit cloudy$lambda$1$lambda$0;
                        cloudy$lambda$1$lambda$0 = CloudyModifierNodeKt.cloudy$lambda$1$lambda$0((CloudyState) obj);
                        return cloudy$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            function1 = (Function1) rememberedValue;
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(884553496, i2, -1, "com.skydoves.cloudy.cloudy (CloudyModifierNode.kt:57)");
        }
        if (!z) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifier;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(InspectionModeKt.getLocalInspectionMode());
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((Boolean) consume).booleanValue()) {
            Modifier m3686blurF8QBwvs$default = BlurKt.m3686blurF8QBwvs$default(modifier, Dp.m6684constructorimpl(i), null, 2, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return m3686blurF8QBwvs$default;
        }
        Modifier then = modifier.then(new CloudyModifierNodeElement(i, function1));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return then;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cloudy$lambda$1$lambda$0(CloudyState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap createCompatibleBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        Intrinsics.checkNotNull(config);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }
}
