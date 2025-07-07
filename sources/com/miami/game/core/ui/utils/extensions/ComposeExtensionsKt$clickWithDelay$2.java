package com.miami.game.core.ui.utils.extensions;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposeExtensions.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ComposeExtensionsKt$clickWithDelay$2 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ long $clicksDelayTimeMs;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ ClickIndicationType $indicationType;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposeExtensionsKt$clickWithDelay$2(long j, ClickIndicationType clickIndicationType, boolean z, Function0<Unit> function0) {
        this.$clicksDelayTimeMs = j;
        this.$indicationType = clickIndicationType;
        this.$enabled = z;
        this.$onClick = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.compose.runtime.Composer] */
    public final Modifier invoke(Modifier composed, Composer composer, int i) {
        IndicationNodeFactory indicationNodeFactory;
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(1586224657);
        ComposerKt.sourceInformation(composer, "C57@2458L105,71@3023L39,69@2900L52:ComposeExtensions.kt#iw6472");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1586224657, i, -1, "com.miami.game.core.ui.utils.extensions.clickWithDelay.<anonymous> (ComposeExtensions.kt:57)");
        }
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ComposeExtensions.kt#9igjgp");
        boolean changed = composer.changed(this.$clicksDelayTimeMs);
        long j = this.$clicksDelayTimeMs;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new MultipleClicksCutter(j);
            composer.updateRememberedValue(rememberedValue);
        }
        final MultipleClicksCutter multipleClicksCutter = (MultipleClicksCutter) rememberedValue;
        composer.endReplaceGroup();
        ClickIndicationType clickIndicationType = this.$indicationType;
        composer.startReplaceGroup(-351489068);
        ComposerKt.sourceInformation(composer, "64@2800L7");
        if (clickIndicationType == ClickIndicationType.NO_INDICATION) {
            indicationNodeFactory = null;
        } else if (clickIndicationType == ClickIndicationType.INFINITE_ROUND) {
            indicationNodeFactory = RippleKt.m2208rippleH2RKhps$default(false, 0.0f, 0L, 6, null);
        } else if (clickIndicationType != ClickIndicationType.THEMED) {
            throw new NoWhenBranchMatchedException();
        } else {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(IndicationKt.getLocalIndication());
            ComposerKt.sourceInformationMarkerEnd(composer);
            indicationNodeFactory = (Indication) consume;
        }
        Indication indication = indicationNodeFactory;
        composer.endReplaceGroup();
        Modifier.Companion companion = Modifier.Companion;
        composer.startReplaceGroup(1849434622);
        ComposerKt.sourceInformation(composer, "CC(remember):ComposeExtensions.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue2);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue2;
        composer.endReplaceGroup();
        Modifier.Companion companion2 = companion;
        boolean z = this.$enabled;
        composer.startReplaceGroup(-1633490746);
        ComposerKt.sourceInformation(composer, "CC(remember):ComposeExtensions.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(multipleClicksCutter) | composer.changed(this.$onClick);
        final Function0<Unit> function0 = this.$onClick;
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$clickWithDelay$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = ComposeExtensionsKt$clickWithDelay$2.invoke$lambda$4$lambda$3(MultipleClicksCutter.this, function0);
                    return invoke$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Modifier m279clickableO2vRcR0$default = ClickableKt.m279clickableO2vRcR0$default(companion2, mutableInteractionSource, indication, z, null, null, rememberedValue3, 24, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m279clickableO2vRcR0$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(MultipleClicksCutter multipleClicksCutter, final Function0 function0) {
        multipleClicksCutter.onClickCutter(new Function0() { // from class: com.miami.game.core.ui.utils.extensions.ComposeExtensionsKt$clickWithDelay$2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$4$lambda$3$lambda$2;
                invoke$lambda$4$lambda$3$lambda$2 = ComposeExtensionsKt$clickWithDelay$2.invoke$lambda$4$lambda$3$lambda$2(Function0.this);
                return invoke$lambda$4$lambda$3$lambda$2;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
