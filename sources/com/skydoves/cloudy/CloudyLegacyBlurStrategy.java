package com.skydoves.cloudy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyLegacyBlurStrategy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0017¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/skydoves/cloudy/CloudyLegacyBlurStrategy;", "Lcom/skydoves/cloudy/CloudyBlurStrategy;", "<init>", "()V", "apply", "Landroidx/compose/ui/Modifier;", "modifier", "radius", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "cloudy_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CloudyLegacyBlurStrategy implements CloudyBlurStrategy {
    public static final int $stable = 0;
    public static final CloudyLegacyBlurStrategy INSTANCE = new CloudyLegacyBlurStrategy();

    private CloudyLegacyBlurStrategy() {
    }

    @Override // com.skydoves.cloudy.CloudyBlurStrategy
    public Modifier apply(Modifier modifier, int i, Function1<? super CloudyState, Unit> onStateChanged, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        composer.startReplaceGroup(1969364055);
        ComposerKt.sourceInformation(composer, "C(apply)N(modifier,radius,onStateChanged):CloudyLegacyBlurStrategy.kt#nw4b6b");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1969364055, i2, -1, "com.skydoves.cloudy.CloudyLegacyBlurStrategy.apply (CloudyLegacyBlurStrategy.kt:57)");
        }
        Modifier then = modifier.then(new CloudyModifierNodeElement(i, onStateChanged));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return then;
    }
}
