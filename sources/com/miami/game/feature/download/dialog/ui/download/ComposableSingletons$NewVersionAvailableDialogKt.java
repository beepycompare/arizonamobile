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
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$NewVersionAvailableDialogKt {
    public static final ComposableSingletons$NewVersionAvailableDialogKt INSTANCE = new ComposableSingletons$NewVersionAvailableDialogKt();

    /* renamed from: lambda$-1405896063  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f74lambda$1405896063 = ComposableLambdaKt.composableLambdaInstance(-1405896063, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt$lambda$-1405896063$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope DialogButtonNo, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
            ComposerKt.sourceInformation(composer, "C83@2959L10,83@2932L85:NewVersionAvailableDialog.kt#as3uag");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1405896063, i, -1, "com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt.lambda$-1405896063.<anonymous> (NewVersionAvailableDialog.kt:83)");
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

    /* renamed from: lambda$-1889472662  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f75lambda$1889472662 = ComposableLambdaKt.composableLambdaInstance(-1889472662, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt$lambda$-1889472662$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope DialogButtonYes, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
            ComposerKt.sourceInformation(composer, "C89@3160L10,89@3133L88:NewVersionAvailableDialog.kt#as3uag");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1889472662, i, -1, "com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$NewVersionAvailableDialogKt.lambda$-1889472662.<anonymous> (NewVersionAvailableDialog.kt:89)");
                }
                TextKt.m2497Text4IGK_g("ЗАГРУЗИТЬ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda$-1405896063$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8336getLambda$1405896063$dialogs_release_web() {
        return f74lambda$1405896063;
    }

    /* renamed from: getLambda$-1889472662$dialogs_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8337getLambda$1889472662$dialogs_release_web() {
        return f75lambda$1889472662;
    }
}
