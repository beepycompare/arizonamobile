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
/* compiled from: RepairGameDialog.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$RepairGameDialogKt {
    public static final ComposableSingletons$RepairGameDialogKt INSTANCE = new ComposableSingletons$RepairGameDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$2083110520 = ComposableLambdaKt.composableLambdaInstance(2083110520, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$RepairGameDialogKt.lambda_2083110520$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-692702417  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f57lambda$692702417 = ComposableLambdaKt.composableLambdaInstance(-692702417, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$RepairGameDialogKt.lambda__692702417$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-692702417$dialogs  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9857getLambda$692702417$dialogs() {
        return f57lambda$692702417;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$2083110520$dialogs() {
        return lambda$2083110520;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2083110520$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C75@2948L10,75@2921L82:RepairGameDialog.kt#wxnm6r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2083110520, i, -1, "com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameDialogKt.lambda$2083110520.<anonymous> (RepairGameDialog.kt:75)");
            }
            TextKt.m3157TextNvy7gAk("НЕТ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__692702417$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C81@3146L10,81@3119L81:RepairGameDialog.kt#wxnm6r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-692702417, i, -1, "com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameDialogKt.lambda$-692702417.<anonymous> (RepairGameDialog.kt:81)");
            }
            TextKt.m3157TextNvy7gAk("ДА", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
