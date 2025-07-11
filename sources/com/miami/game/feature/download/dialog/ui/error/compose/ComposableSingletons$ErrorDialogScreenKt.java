package com.miami.game.feature.download.dialog.ui.error.compose;

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
/* compiled from: ErrorDialogScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$ErrorDialogScreenKt {
    public static final ComposableSingletons$ErrorDialogScreenKt INSTANCE = new ComposableSingletons$ErrorDialogScreenKt();

    /* renamed from: lambda$-1032883188  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f76lambda$1032883188 = ComposableLambdaKt.composableLambdaInstance(-1032883188, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$ErrorDialogScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1032883188$lambda$0;
            lambda__1032883188$lambda$0 = ComposableSingletons$ErrorDialogScreenKt.lambda__1032883188$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1032883188$lambda$0;
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$24227829 = ComposableLambdaKt.composableLambdaInstance(24227829, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$ErrorDialogScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_24227829$lambda$1;
            lambda_24227829$lambda$1 = ComposableSingletons$ErrorDialogScreenKt.lambda_24227829$lambda$1((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_24227829$lambda$1;
        }
    });

    /* renamed from: getLambda$-1032883188$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8347getLambda$1032883188$dialogs_release_web() {
        return f76lambda$1032883188;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$24227829$dialogs_release_web() {
        return lambda$24227829;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1032883188$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C69@2384L10,69@2357L86:ErrorDialogScreen.kt#d3gn1w");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1032883188, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$ErrorDialogScreenKt.lambda$-1032883188.<anonymous> (ErrorDialogScreen.kt:69)");
            }
            TextKt.m2497Text4IGK_g("ЗАКРЫТЬ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_24227829$lambda$1(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C75@2586L10,75@2559L88:ErrorDialogScreen.kt#d3gn1w");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(24227829, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$ErrorDialogScreenKt.lambda$24227829.<anonymous> (ErrorDialogScreen.kt:75)");
            }
            TextKt.m2497Text4IGK_g("ПОВТОРИТЬ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
