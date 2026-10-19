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
/* compiled from: ModsInstructionsDialog.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$ModsInstructionsDialogKt {
    public static final ComposableSingletons$ModsInstructionsDialogKt INSTANCE = new ComposableSingletons$ModsInstructionsDialogKt();

    /* renamed from: lambda$-160609614  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f71lambda$160609614 = ComposableLambdaKt.composableLambdaInstance(-160609614, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$ModsInstructionsDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ModsInstructionsDialogKt.lambda__160609614$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-70836385  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f73lambda$70836385 = ComposableLambdaKt.composableLambdaInstance(-70836385, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$ModsInstructionsDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ModsInstructionsDialogKt.lambda__70836385$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1983831800  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f72lambda$1983831800 = ComposableLambdaKt.composableLambdaInstance(-1983831800, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$ModsInstructionsDialogKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ModsInstructionsDialogKt.lambda__1983831800$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1244585443 = ComposableLambdaKt.composableLambdaInstance(1244585443, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$ModsInstructionsDialogKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ModsInstructionsDialogKt.lambda_1244585443$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-160609614$settings  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9890getLambda$160609614$settings() {
        return f71lambda$160609614;
    }

    /* renamed from: getLambda$-1983831800$settings  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9891getLambda$1983831800$settings() {
        return f72lambda$1983831800;
    }

    /* renamed from: getLambda$-70836385$settings  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9892getLambda$70836385$settings() {
        return f73lambda$70836385;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1244585443$settings() {
        return lambda$1244585443;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__160609614$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C111@4829L44,112@4921L10,110@4792L217:ModsInstructionsDialog.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160609614, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$ModsInstructionsDialogKt.lambda$-160609614.<anonymous> (ModsInstructionsDialog.kt:110)");
            }
            TextKt.m3157TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mods_structure_back, composer, 0), null, Color.Companion.m5385getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__70836385$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C124@5482L44,125@5578L10,123@5441L233:ModsInstructionsDialog.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-70836385, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$ModsInstructionsDialogKt.lambda$-70836385.<anonymous> (ModsInstructionsDialog.kt:123)");
            }
            TextKt.m3157TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mods_structure_show, composer, 0), null, Color.Companion.m5385getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1983831800$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C131@5821L52,132@5925L10,130@5780L241:ModsInstructionsDialog.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1983831800, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$ModsInstructionsDialogKt.lambda$-1983831800.<anonymous> (ModsInstructionsDialog.kt:130)");
            }
            TextKt.m3157TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mods_instructions_configure, composer, 0), null, Color.Companion.m5385getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1244585443$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C139@6229L53,140@6338L10,138@6184L304:ModsInstructionsDialog.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1244585443, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$ModsInstructionsDialogKt.lambda$1244585443.<anonymous> (ModsInstructionsDialog.kt:138)");
            }
            TextKt.m3157TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mods_instructions_debug_mode, composer, 0), null, Color.Companion.m5385getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 24576, 114682);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
