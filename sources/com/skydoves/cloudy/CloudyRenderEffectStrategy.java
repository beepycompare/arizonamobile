package com.skydoves.cloudy;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.FunctionKeyMeta;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidRenderEffect_androidKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyRenderEffectStrategy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0017¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/skydoves/cloudy/CloudyRenderEffectStrategy;", "Lcom/skydoves/cloudy/CloudyBlurStrategy;", "<init>", "()V", "apply", "Landroidx/compose/ui/Modifier;", "modifier", "radius", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CloudyRenderEffectStrategy implements CloudyBlurStrategy {
    public static final int $stable = 0;
    public static final CloudyRenderEffectStrategy INSTANCE = new CloudyRenderEffectStrategy();

    private CloudyRenderEffectStrategy() {
    }

    @Override // com.skydoves.cloudy.CloudyBlurStrategy
    @FunctionKeyMeta(endOffset = 2334, key = 70788009, startOffset = 1845)
    public Modifier apply(Modifier modifier, int i, Function1<? super CloudyState, Unit> onStateChanged, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        composer.startReplaceGroup(70788009);
        ComposerKt.sourceInformation(composer, "C(apply)N(modifier,radius,onStateChanged)48@1983L91,48@1960L114,60@2193L137:CloudyRenderEffectStrategy.kt#nw4b6b");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(70788009, i2, -1, "com.skydoves.cloudy.CloudyRenderEffectStrategy.apply (CloudyRenderEffectStrategy.kt:47)");
        }
        Integer valueOf = Integer.valueOf(i);
        ComposerKt.sourceInformationMarkerStart(composer, -692195580, "CC(remember):CloudyRenderEffectStrategy.kt#9igjgp");
        boolean z = ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(onStateChanged)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        CloudyRenderEffectStrategy$apply$1$1 rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new CloudyRenderEffectStrategy$apply$1$1(i, onStateChanged, null);
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue, composer, (i2 >> 3) & 14);
        if (i == 0) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifier;
        }
        final float f = i / 2.0f;
        ComposerKt.sourceInformationMarkerStart(composer, -692188814, "CC(remember):CloudyRenderEffectStrategy.kt#9igjgp");
        boolean changed = composer.changed(f);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.skydoves.cloudy.CloudyRenderEffectStrategy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit apply$lambda$1$0;
                    apply$lambda$1$0 = CloudyRenderEffectStrategy.apply$lambda$1$0(f, (GraphicsLayerScope) obj);
                    return apply$lambda$1$0;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return graphicsLayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit apply$lambda$1$0(float f, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        RenderEffect createBlurEffect = RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP);
        Intrinsics.checkNotNullExpressionValue(createBlurEffect, "createBlurEffect(...)");
        graphicsLayer.setRenderEffect(AndroidRenderEffect_androidKt.asComposeRenderEffect(createBlurEffect));
        return Unit.INSTANCE;
    }
}
