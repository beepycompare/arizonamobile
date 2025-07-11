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
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$ConnectionDialogKt {
    public static final ComposableSingletons$ConnectionDialogKt INSTANCE = new ComposableSingletons$ConnectionDialogKt();

    /* renamed from: lambda$-751471044  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f72lambda$751471044 = ComposableLambdaKt.composableLambdaInstance(-751471044, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__751471044$lambda$0;
            lambda__751471044$lambda$0 = ComposableSingletons$ConnectionDialogKt.lambda__751471044$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__751471044$lambda$0;
        }
    });

    /* renamed from: lambda$-1711092251  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f71lambda$1711092251 = ComposableLambdaKt.composableLambdaInstance(-1711092251, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1711092251$lambda$1;
            lambda__1711092251$lambda$1 = ComposableSingletons$ConnectionDialogKt.lambda__1711092251$lambda$1((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1711092251$lambda$1;
        }
    });

    /* renamed from: getLambda$-1711092251$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8331getLambda$1711092251$dialogs_release_web() {
        return f71lambda$1711092251;
    }

    /* renamed from: getLambda$-751471044$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8332getLambda$751471044$dialogs_release_web() {
        return f72lambda$751471044;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__751471044$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C51@2112L10,51@2085L85:ConnectionDialog.kt#yp5s1q");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-751471044, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt.lambda$-751471044.<anonymous> (ConnectionDialog.kt:51)");
            }
            TextKt.m2497Text4IGK_g("ОТМЕНА", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1711092251$lambda$1(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C63@2535L10,63@2508L91:ConnectionDialog.kt#yp5s1q");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1711092251, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ComposableSingletons$ConnectionDialogKt.lambda$-1711092251.<anonymous> (ConnectionDialog.kt:63)");
            }
            TextKt.m2497Text4IGK_g("ПОДКЛЮЧИТЬСЯ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
