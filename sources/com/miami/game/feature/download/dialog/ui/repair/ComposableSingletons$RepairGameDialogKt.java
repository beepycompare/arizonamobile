package com.miami.game.feature.download.dialog.ui.repair;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.media3.extractor.WavUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RepairGameDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$RepairGameDialogKt {
    public static final ComposableSingletons$RepairGameDialogKt INSTANCE = new ComposableSingletons$RepairGameDialogKt();

    /* renamed from: lambda$-1796529959  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f78lambda$1796529959 = ComposableLambdaKt.composableLambdaInstance(-1796529959, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1796529959$lambda$0;
            lambda__1796529959$lambda$0 = ComposableSingletons$RepairGameDialogKt.lambda__1796529959$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1796529959$lambda$0;
        }
    });

    /* renamed from: lambda$-277375600  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f79lambda$277375600 = ComposableLambdaKt.composableLambdaInstance(-277375600, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__277375600$lambda$1;
            lambda__277375600$lambda$1 = ComposableSingletons$RepairGameDialogKt.lambda__277375600$lambda$1((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__277375600$lambda$1;
        }
    });

    /* renamed from: getLambda$-1796529959$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8355getLambda$1796529959$dialogs_release_web() {
        return f78lambda$1796529959;
    }

    /* renamed from: getLambda$-277375600$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8356getLambda$277375600$dialogs_release_web() {
        return f79lambda$277375600;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1796529959$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C75@2948L10,75@2921L82:RepairGameDialog.kt#wxnm6r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1796529959, i, -1, "com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameDialogKt.lambda$-1796529959.<anonymous> (RepairGameDialog.kt:75)");
            }
            TextKt.m2497Text4IGK_g("НЕТ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__277375600$lambda$1(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C81@3146L10,81@3119L81:RepairGameDialog.kt#wxnm6r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-277375600, i, -1, "com.miami.game.feature.download.dialog.ui.repair.ComposableSingletons$RepairGameDialogKt.lambda$-277375600.<anonymous> (RepairGameDialog.kt:81)");
            }
            TextKt.m2497Text4IGK_g("ДА", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
