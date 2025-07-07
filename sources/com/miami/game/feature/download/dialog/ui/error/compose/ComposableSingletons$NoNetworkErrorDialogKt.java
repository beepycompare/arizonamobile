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
/* compiled from: NoNetworkErrorDialog.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$NoNetworkErrorDialogKt {
    public static final ComposableSingletons$NoNetworkErrorDialogKt INSTANCE = new ComposableSingletons$NoNetworkErrorDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$286452819 = ComposableLambdaKt.composableLambdaInstance(286452819, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$NoNetworkErrorDialogKt$lambda$286452819$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope DialogButtonYes, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
            ComposerKt.sourceInformation(composer, "C74@2788L10,74@2761L88:NoNetworkErrorDialog.kt#d3gn1w");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(286452819, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ComposableSingletons$NoNetworkErrorDialogKt.lambda$286452819.<anonymous> (NoNetworkErrorDialog.kt:74)");
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

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$286452819$dialogs_release_web() {
        return lambda$286452819;
    }
}
