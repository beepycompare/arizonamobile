package com.miami.game.feature.download.dialog.ui.download;

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
/* compiled from: NewVersionAvailableDialog.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$NewVersionAvailableDialogKt {
    public static final ComposableSingletons$NewVersionAvailableDialogKt INSTANCE = new ComposableSingletons$NewVersionAvailableDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$786617730 = ComposableLambdaKt.composableLambdaInstance(786617730, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NewVersionAvailableDialogKt.lambda_786617730$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$303041131 = ComposableLambdaKt.composableLambdaInstance(303041131, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NewVersionAvailableDialogKt.lambda_303041131$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$303041131$dialogs() {
        return lambda$303041131;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$786617730$dialogs() {
        return lambda$786617730;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_786617730$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C83@2959L10,83@2932L85:NewVersionAvailableDialog.kt#as3uag");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(786617730, i, -1, "com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt.lambda$786617730.<anonymous> (NewVersionAvailableDialog.kt:83)");
            }
            TextKt.m3157TextNvy7gAk("ОТМЕНА", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_303041131$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C89@3160L10,89@3133L88:NewVersionAvailableDialog.kt#as3uag");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(303041131, i, -1, "com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt.lambda$303041131.<anonymous> (NewVersionAvailableDialog.kt:89)");
            }
            TextKt.m3157TextNvy7gAk("ЗАГРУЗИТЬ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
