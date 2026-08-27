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

    /* renamed from: lambda$-751471044  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f52lambda$751471044 = ComposableLambdaKt.composableLambdaInstance(-751471044, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ConnectionDialogKt.lambda__751471044$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1711092251  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f51lambda$1711092251 = ComposableLambdaKt.composableLambdaInstance(-1711092251, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ConnectionDialogKt.lambda__1711092251$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1711092251$dialogs  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9802getLambda$1711092251$dialogs() {
        return f51lambda$1711092251;
    }

    /* renamed from: getLambda$-751471044$dialogs  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9803getLambda$751471044$dialogs() {
        return f52lambda$751471044;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__751471044$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C51@2107L10,51@2080L85:ConnectionDialog.kt#yp5s1q");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-751471044, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt.lambda$-751471044.<anonymous> (ConnectionDialog.kt:51)");
            }
            TextKt.m3157TextNvy7gAk("ОТМЕНА", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1711092251$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C63@2530L10,63@2503L91:ConnectionDialog.kt#yp5s1q");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1711092251, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt.lambda$-1711092251.<anonymous> (ConnectionDialog.kt:63)");
            }
            TextKt.m3157TextNvy7gAk("ПОДКЛЮЧИТЬСЯ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
