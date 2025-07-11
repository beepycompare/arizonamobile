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
/* compiled from: FailDownloadDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$FailDownloadDialogKt {
    public static final ComposableSingletons$FailDownloadDialogKt INSTANCE = new ComposableSingletons$FailDownloadDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1464513202 = ComposableLambdaKt.composableLambdaInstance(1464513202, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$FailDownloadDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1464513202$lambda$0;
            lambda_1464513202$lambda$0 = ComposableSingletons$FailDownloadDialogKt.lambda_1464513202$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1464513202$lambda$0;
        }
    });

    /* renamed from: lambda$-1143154327  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f77lambda$1143154327 = ComposableLambdaKt.composableLambdaInstance(-1143154327, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$FailDownloadDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1143154327$lambda$1;
            lambda__1143154327$lambda$1 = ComposableSingletons$FailDownloadDialogKt.lambda__1143154327$lambda$1((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1143154327$lambda$1;
        }
    });

    /* renamed from: getLambda$-1143154327$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8348getLambda$1143154327$dialogs_release_web() {
        return f77lambda$1143154327;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1464513202$dialogs_release_web() {
        return lambda$1464513202;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1464513202$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C65@2383L10,65@2356L85:FailDownloadDialog.kt#d3gn1w");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464513202, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$FailDownloadDialogKt.lambda$1464513202.<anonymous> (FailDownloadDialog.kt:65)");
            }
            TextKt.m2497Text4IGK_g("ОТМЕНА", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1143154327$lambda$1(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C71@2584L10,71@2557L88:FailDownloadDialog.kt#d3gn1w");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1143154327, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$FailDownloadDialogKt.lambda$-1143154327.<anonymous> (FailDownloadDialog.kt:71)");
            }
            TextKt.m2497Text4IGK_g("ПОВТОРИТЬ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
