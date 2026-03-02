package com.skydoves.cloudy;

import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.FunctionKeyMeta;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: Cloudy.android.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"cloudy", "Landroidx/compose/ui/Modifier;", "radius", "", "enabled", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "(Landroidx/compose/ui/Modifier;IZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "cloudy_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Cloudy_androidKt {
    @FunctionKeyMeta(endOffset = 1630, key = 503794224, startOffset = 1041)
    public static final Modifier cloudy(Modifier modifier, int i, boolean z, Function1<? super CloudyState, Unit> function1, Composer composer, int i2, int i3) {
        CloudyLegacyBlurStrategy cloudyLegacyBlurStrategy;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        composer.startReplaceGroup(503794224);
        ComposerKt.sourceInformation(composer, "C(cloudy)N(radius,enabled,onStateChanged)56@3003L2,40@1317L7,50@1539L89:Cloudy.android.kt#nw4b6b");
        if ((i3 & 1) != 0) {
            i = 10;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            z = true;
        }
        if ((i3 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1184992398, "CC(remember):Cloudy.android.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.skydoves.cloudy.Cloudy_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit cloudy$lambda$0$0;
                        cloudy$lambda$0$0 = Cloudy_androidKt.cloudy$lambda$0$0((CloudyState) obj);
                        return cloudy$lambda$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function1<? super CloudyState, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(503794224, i2, -1, "com.skydoves.cloudy.cloudy (Cloudy.android.kt:33)");
        }
        if (i4 >= 0) {
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
                Modifier m4295blurF8QBwvs$default = BlurKt.m4295blurF8QBwvs$default(modifier, Dp.m7555constructorimpl(i4), null, 2, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m4295blurF8QBwvs$default;
            }
            if (Build.VERSION.SDK_INT >= 31) {
                cloudyLegacyBlurStrategy = CloudyRenderEffectStrategy.INSTANCE;
            } else {
                cloudyLegacyBlurStrategy = CloudyLegacyBlurStrategy.INSTANCE;
            }
            Modifier apply = cloudyLegacyBlurStrategy.apply(modifier, i4, function12, composer, (i2 & WebSocketProtocol.PAYLOAD_SHORT) | ((i2 >> 3) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return apply;
        }
        throw new IllegalArgumentException(("Blur radius must be non-negative, but was " + i4).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cloudy$lambda$0$0(CloudyState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
