package com.miami.game.feature.download.dialog.ui.repair;

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
/* compiled from: RepairGameSuccess.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$RepairGameSuccessKt {
    public static final ComposableSingletons$RepairGameSuccessKt INSTANCE = new ComposableSingletons$RepairGameSuccessKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1248275720 = ComposableLambdaKt.composableLambdaInstance(1248275720, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameSuccessKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1248275720$lambda$0;
            lambda_1248275720$lambda$0 = ComposableSingletons$RepairGameSuccessKt.lambda_1248275720$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1248275720$lambda$0;
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1248275720$dialogs_release() {
        return lambda$1248275720;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1248275720$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C86@2980L10,86@2953L84:RepairGameSuccess.kt#wxnm6r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1248275720, i, -1, "com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameSuccessKt.lambda$1248275720.<anonymous> (RepairGameSuccess.kt:86)");
            }
            TextKt.m3168TextNvy7gAk("НАЗАД", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
