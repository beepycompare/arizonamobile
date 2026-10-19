package com.miami.game.feature.download.dialog.ui.setup;

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
/* compiled from: SetupDialog.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$SetupDialogKt {
    public static final ComposableSingletons$SetupDialogKt INSTANCE = new ComposableSingletons$SetupDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$579915652 = ComposableLambdaKt.composableLambdaInstance(579915652, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.setup.ComposableSingletons$SetupDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SetupDialogKt.lambda_579915652$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$579915652$dialogs() {
        return lambda$579915652;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_579915652$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C109@4347L10,109@4320L85:SetupDialog.kt#18sjrx");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(579915652, i, -1, "com.miami.game.feature.download.dialog.ui.setup.ComposableSingletons$SetupDialogKt.lambda$579915652.<anonymous> (SetupDialog.kt:109)");
            }
            TextKt.m3157TextNvy7gAk("ОТМЕНА", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
