package com.miami.game.feature.download.dialog.ui.download;

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
/* compiled from: NewVersionAvailableDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$NewVersionAvailableDialogKt {
    public static final ComposableSingletons$NewVersionAvailableDialogKt INSTANCE = new ComposableSingletons$NewVersionAvailableDialogKt();

    /* renamed from: lambda$-1405896063  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f74lambda$1405896063 = ComposableLambdaKt.composableLambdaInstance(-1405896063, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1405896063$lambda$0;
            lambda__1405896063$lambda$0 = ComposableSingletons$NewVersionAvailableDialogKt.lambda__1405896063$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1405896063$lambda$0;
        }
    });

    /* renamed from: lambda$-1889472662  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f75lambda$1889472662 = ComposableLambdaKt.composableLambdaInstance(-1889472662, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1889472662$lambda$1;
            lambda__1889472662$lambda$1 = ComposableSingletons$NewVersionAvailableDialogKt.lambda__1889472662$lambda$1((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1889472662$lambda$1;
        }
    });

    /* renamed from: getLambda$-1405896063$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8341getLambda$1405896063$dialogs_release_web() {
        return f74lambda$1405896063;
    }

    /* renamed from: getLambda$-1889472662$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8342getLambda$1889472662$dialogs_release_web() {
        return f75lambda$1889472662;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1405896063$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C83@2959L10,83@2932L85:NewVersionAvailableDialog.kt#as3uag");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1405896063, i, -1, "com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt.lambda$-1405896063.<anonymous> (NewVersionAvailableDialog.kt:83)");
            }
            TextKt.m2497Text4IGK_g("ОТМЕНА", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1889472662$lambda$1(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C89@3160L10,89@3133L88:NewVersionAvailableDialog.kt#as3uag");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1889472662, i, -1, "com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt.lambda$-1889472662.<anonymous> (NewVersionAvailableDialog.kt:89)");
            }
            TextKt.m2497Text4IGK_g("ЗАГРУЗИТЬ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
