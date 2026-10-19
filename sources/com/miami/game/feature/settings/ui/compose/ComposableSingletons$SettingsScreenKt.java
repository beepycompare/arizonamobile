package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.ui.classic.settings.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$SettingsScreenKt {
    public static final ComposableSingletons$SettingsScreenKt INSTANCE = new ComposableSingletons$SettingsScreenKt();

    /* renamed from: lambda$-1336153321  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f76lambda$1336153321 = ComposableLambdaKt.composableLambdaInstance(-1336153321, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__1336153321$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1302805746  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f75lambda$1302805746 = ComposableLambdaKt.composableLambdaInstance(-1302805746, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsScreenKt.lambda__1302805746$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1302805746$settings  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9894getLambda$1302805746$settings() {
        return f75lambda$1302805746;
    }

    /* renamed from: getLambda$-1336153321$settings  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9895getLambda$1336153321$settings() {
        return f76lambda$1336153321;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1336153321$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C548@23069L10,549@23118L41,547@23021L198:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1336153321, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsScreenKt.lambda$-1336153321.<anonymous> (SettingsScreen.kt:547)");
            }
            TextKt.m3157TextNvy7gAk(StringResources_androidKt.stringResource(R.string.vice_city_cancel, composer, 0), null, Color.Companion.m5385getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1302805746$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C558@23421L10,559@23470L41,557@23373L198:SettingsScreen.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1302805746, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsScreenKt.lambda$-1302805746.<anonymous> (SettingsScreen.kt:557)");
            }
            TextKt.m3157TextNvy7gAk(StringResources_androidKt.stringResource(R.string.vice_city_delete, composer, 0), null, Color.Companion.m5385getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
