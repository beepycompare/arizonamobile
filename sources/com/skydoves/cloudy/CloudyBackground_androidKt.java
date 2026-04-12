package com.skydoves.cloudy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.FunctionKeyMeta;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.skydoves.cloudy.CloudyProgressive;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyBackground.android.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001ac\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"TAG", "", "sky", "Landroidx/compose/ui/Modifier;", "Lcom/skydoves/cloudy/Sky;", "(Landroidx/compose/ui/Modifier;Lcom/skydoves/cloudy/Sky;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "cloudy", "radius", "", "progressive", "Lcom/skydoves/cloudy/CloudyProgressive;", "tint", "Landroidx/compose/ui/graphics/Color;", "enabled", "", "cpuBlurEnabled", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "cloudy-NpZTi58", "(Landroidx/compose/ui/Modifier;Lcom/skydoves/cloudy/Sky;ILcom/skydoves/cloudy/CloudyProgressive;JZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "cloudy_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CloudyBackground_androidKt {
    private static final String TAG = "CloudyBackground";

    @FunctionKeyMeta(endOffset = 2912, key = -2029719754, startOffset = 2833)
    public static final Modifier sky(Modifier modifier, Sky sky, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(sky, "sky");
        ComposerKt.sourceInformationMarkerStart(composer, -2029719754, "C(sky)N(sky):CloudyBackground.android.kt#nw4b6b");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2029719754, i, -1, "com.skydoves.cloudy.sky (CloudyBackground.android.kt:69)");
        }
        Modifier then = modifier.then(new SkyModifierElement(sky));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return then;
    }

    @FunctionKeyMeta(endOffset = 4051, key = -1688490395, startOffset = 3089)
    /* renamed from: cloudy-NpZTi58  reason: not valid java name */
    public static final Modifier m9142cloudyNpZTi58(Modifier cloudy, Sky sky, int i, CloudyProgressive cloudyProgressive, long j, boolean z, boolean z2, Function1<? super CloudyState, Unit> function1, Composer composer, int i2, int i3) {
        Function1<? super CloudyState, Unit> function12;
        Intrinsics.checkNotNullParameter(cloudy, "$this$cloudy");
        Intrinsics.checkNotNullParameter(sky, "sky");
        composer.startReplaceGroup(-1688490395);
        ComposerKt.sourceInformation(composer, "C(cloudy)N(sky,radius,progressive,tint:c#ui.graphics.Color,enabled,cpuBlurEnabled,onStateChanged)145@5053L2,93@3529L281,93@3498L312:CloudyBackground.android.kt#nw4b6b");
        int i4 = (i3 & 2) != 0 ? 20 : i;
        CloudyProgressive.None none = (i3 & 4) != 0 ? CloudyProgressive.None.INSTANCE : cloudyProgressive;
        long m4807getTransparent0d7_KjU = (i3 & 8) != 0 ? Color.Companion.m4807getTransparent0d7_KjU() : j;
        boolean z3 = (i3 & 16) != 0 ? true : z;
        boolean z4 = (i3 & 32) != 0 ? false : z2;
        if ((i3 & 64) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 858431143, "CC(remember):CloudyBackground.android.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.skydoves.cloudy.CloudyBackground_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit cloudy_NpZTi58$lambda$0$0;
                        cloudy_NpZTi58$lambda$0$0 = CloudyBackground_androidKt.cloudy_NpZTi58$lambda$0$0((CloudyState) obj);
                        return cloudy_NpZTi58$lambda$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            function12 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            function12 = function1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1688490395, i2, -1, "com.skydoves.cloudy.cloudy (CloudyBackground.android.kt:85)");
        }
        if (i4 >= 0) {
            if (!z3) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return cloudy;
            }
            Boolean valueOf = Boolean.valueOf(z4);
            ComposerKt.sourceInformationMarkerStart(composer, 858382654, "CC(remember):CloudyBackground.android.kt#9igjgp");
            boolean z5 = (((3670016 & i2) ^ 1572864) > 1048576 && composer.changed(z4)) || (i2 & 1572864) == 1048576;
            CloudyBackground_androidKt$cloudy$3$1 rememberedValue2 = composer.rememberedValue();
            if (z5 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new CloudyBackground_androidKt$cloudy$3$1(z4, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, composer, (i2 >> 18) & 14);
            Modifier then = cloudy.then(new CloudyBackgroundModifierElement(sky, i4, none, m4807getTransparent0d7_KjU, z4, function12, null));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return then;
        }
        throw new IllegalArgumentException(("Blur radius must be non-negative, but was " + i4).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cloudy_NpZTi58$lambda$0$0(CloudyState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
