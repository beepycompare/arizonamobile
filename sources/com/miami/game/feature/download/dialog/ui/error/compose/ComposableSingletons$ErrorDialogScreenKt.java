package com.miami.game.feature.download.dialog.ui.error.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorDialogScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$ErrorDialogScreenKt {
    public static final ComposableSingletons$ErrorDialogScreenKt INSTANCE = new ComposableSingletons$ErrorDialogScreenKt();

    /* renamed from: lambda$-233308659  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f54lambda$233308659 = ComposableLambdaKt.composableLambdaInstance(-233308659, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$ErrorDialogScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ErrorDialogScreenKt.lambda__233308659$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$823802358 = ComposableLambdaKt.composableLambdaInstance(823802358, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$ErrorDialogScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ErrorDialogScreenKt.lambda_823802358$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-233308659$dialogs  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9849getLambda$233308659$dialogs() {
        return f54lambda$233308659;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$823802358$dialogs() {
        return lambda$823802358;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__233308659$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C69@2384L10,69@2357L86:ErrorDialogScreen.kt#d3gn1w");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-233308659, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$ErrorDialogScreenKt.lambda$-233308659.<anonymous> (ErrorDialogScreen.kt:69)");
            }
            TextKt.m3157TextNvy7gAk("ЗАКРЫТЬ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_823802358$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C75@2586L10,75@2559L88:ErrorDialogScreen.kt#d3gn1w");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(823802358, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$ErrorDialogScreenKt.lambda$823802358.<anonymous> (ErrorDialogScreen.kt:75)");
            }
            TextKt.m3157TextNvy7gAk("ПОВТОРИТЬ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
