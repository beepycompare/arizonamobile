package com.skydoves.cloudy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.FunctionKeyMeta;
import kotlin.Metadata;
/* compiled from: Sky.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberSky", "Lcom/skydoves/cloudy/Sky;", "(Landroidx/compose/runtime/Composer;I)Lcom/skydoves/cloudy/Sky;", "cloudy_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SkyKt {
    @FunctionKeyMeta(endOffset = 4757, key = -441141553, startOffset = 4714)
    public static final Sky rememberSky(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -441141553, "C(rememberSky)158@4739L18:Sky.kt#nw4b6b");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-441141553, i, -1, "com.skydoves.cloudy.rememberSky (Sky.kt:158)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1264730689, "CC(remember):Sky.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Sky();
            composer.updateRememberedValue(rememberedValue);
        }
        Sky sky = (Sky) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sky;
    }
}
