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
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$FailDownloadDialogKt {
    public static final ComposableSingletons$FailDownloadDialogKt INSTANCE = new ComposableSingletons$FailDownloadDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1464513202 = ComposableLambdaKt.composableLambdaInstance(1464513202, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$FailDownloadDialogKt$lambda$1464513202$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope DialogButtonNo, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
            ComposerKt.sourceInformation(composer, "C65@2383L10,65@2356L85:FailDownloadDialog.kt#d3gn1w");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1464513202, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$FailDownloadDialogKt.lambda$1464513202.<anonymous> (FailDownloadDialog.kt:65)");
                }
                TextKt.m2497Text4IGK_g("ОТМЕНА", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda$-1143154327  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f77lambda$1143154327 = ComposableLambdaKt.composableLambdaInstance(-1143154327, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$FailDownloadDialogKt$lambda$-1143154327$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope DialogButtonYes, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
            ComposerKt.sourceInformation(composer, "C71@2584L10,71@2557L88:FailDownloadDialog.kt#d3gn1w");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1143154327, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$FailDownloadDialogKt.lambda$-1143154327.<anonymous> (FailDownloadDialog.kt:71)");
                }
                TextKt.m2497Text4IGK_g("ПОВТОРИТЬ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda$-1143154327$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8340getLambda$1143154327$dialogs_release_web() {
        return f77lambda$1143154327;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1464513202$dialogs_release_web() {
        return lambda$1464513202;
    }
}
