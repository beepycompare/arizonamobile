package com.miami.game.feature.download.dialog.ui.connection;

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
/* compiled from: ConnectionDialog.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$ConnectionDialogKt {
    public static final ComposableSingletons$ConnectionDialogKt INSTANCE = new ComposableSingletons$ConnectionDialogKt();

    /* renamed from: lambda$-751471044  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f72lambda$751471044 = ComposableLambdaKt.composableLambdaInstance(-751471044, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt$lambda$-751471044$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope DialogButtonNo, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
            ComposerKt.sourceInformation(composer, "C51@2112L10,51@2085L85:ConnectionDialog.kt#yp5s1q");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-751471044, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt.lambda$-751471044.<anonymous> (ConnectionDialog.kt:51)");
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

    /* renamed from: lambda$-1711092251  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f71lambda$1711092251 = ComposableLambdaKt.composableLambdaInstance(-1711092251, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt$lambda$-1711092251$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope DialogButtonYes, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
            ComposerKt.sourceInformation(composer, "C63@2535L10,63@2508L91:ConnectionDialog.kt#yp5s1q");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1711092251, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt.lambda$-1711092251.<anonymous> (ConnectionDialog.kt:63)");
                }
                TextKt.m2497Text4IGK_g("ПОДКЛЮЧИТЬСЯ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda$-1711092251$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8330getLambda$1711092251$dialogs_release_web() {
        return f71lambda$1711092251;
    }

    /* renamed from: getLambda$-751471044$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8331getLambda$751471044$dialogs_release_web() {
        return f72lambda$751471044;
    }
}
