package com.miami.game.feature.download.dialog.ui.connection;

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
/* compiled from: ConnectionDialog.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$ConnectionDialogKt {
    public static final ComposableSingletons$ConnectionDialogKt INSTANCE = new ComposableSingletons$ConnectionDialogKt();

    /* renamed from: lambda$-49536451  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f52lambda$49536451 = ComposableLambdaKt.composableLambdaInstance(-49536451, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ConnectionDialogKt.lambda__49536451$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1009157658  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f51lambda$1009157658 = ComposableLambdaKt.composableLambdaInstance(-1009157658, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ConnectionDialogKt.lambda__1009157658$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1009157658$dialogs  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9845getLambda$1009157658$dialogs() {
        return f51lambda$1009157658;
    }

    /* renamed from: getLambda$-49536451$dialogs  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9846getLambda$49536451$dialogs() {
        return f52lambda$49536451;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__49536451$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C51@2107L10,51@2080L85:ConnectionDialog.kt#yp5s1q");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-49536451, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt.lambda$-49536451.<anonymous> (ConnectionDialog.kt:51)");
            }
            TextKt.m3157TextNvy7gAk("ОТМЕНА", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1009157658$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C63@2530L10,63@2503L91:ConnectionDialog.kt#yp5s1q");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1009157658, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt.lambda$-1009157658.<anonymous> (ConnectionDialog.kt:63)");
            }
            TextKt.m3157TextNvy7gAk("ПОДКЛЮЧИТЬСЯ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
