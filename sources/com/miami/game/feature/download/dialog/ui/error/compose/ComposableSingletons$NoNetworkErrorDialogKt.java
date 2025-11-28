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
/* compiled from: NoNetworkErrorDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$NoNetworkErrorDialogKt {
    public static final ComposableSingletons$NoNetworkErrorDialogKt INSTANCE = new ComposableSingletons$NoNetworkErrorDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$286452819 = ComposableLambdaKt.composableLambdaInstance(286452819, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$NoNetworkErrorDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_286452819$lambda$0;
            lambda_286452819$lambda$0 = ComposableSingletons$NoNetworkErrorDialogKt.lambda_286452819$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_286452819$lambda$0;
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$286452819$dialogs_release() {
        return lambda$286452819;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_286452819$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C74@2788L10,74@2761L88:NoNetworkErrorDialog.kt#d3gn1w");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(286452819, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$NoNetworkErrorDialogKt.lambda$286452819.<anonymous> (NoNetworkErrorDialog.kt:74)");
            }
            TextKt.m3169TextNvy7gAk("ПОВТОРИТЬ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
