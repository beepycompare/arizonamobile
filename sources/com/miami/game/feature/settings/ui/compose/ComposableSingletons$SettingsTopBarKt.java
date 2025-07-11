package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.miami.game.core.drawable.resources.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsTopBar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$SettingsTopBarKt {
    public static final ComposableSingletons$SettingsTopBarKt INSTANCE = new ComposableSingletons$SettingsTopBarKt();

    /* renamed from: lambda$-1729539213  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f86lambda$1729539213 = ComposableLambdaKt.composableLambdaInstance(-1729539213, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsTopBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1729539213$lambda$0;
            lambda__1729539213$lambda$0 = ComposableSingletons$SettingsTopBarKt.lambda__1729539213$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1729539213$lambda$0;
        }
    });

    /* renamed from: getLambda$-1729539213$settings_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8416getLambda$1729539213$settings_release_web() {
        return f86lambda$1729539213;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1729539213$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C49@1777L85,48@1746L267:SettingsTopBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1729539213, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsTopBarKt.lambda$-1729539213.<anonymous> (SettingsTopBar.kt:48)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_back_launcher, composer, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(72)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
