package com.miami.game.feature.download.dialog.ui.download;

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
/* compiled from: CacheUpdateDialog.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$CacheUpdateDialogKt {
    public static final ComposableSingletons$CacheUpdateDialogKt INSTANCE = new ComposableSingletons$CacheUpdateDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$2143907042 = ComposableLambdaKt.composableLambdaInstance(2143907042, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$CacheUpdateDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CacheUpdateDialogKt.lambda_2143907042$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1292262873 = ComposableLambdaKt.composableLambdaInstance(1292262873, false, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$CacheUpdateDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CacheUpdateDialogKt.lambda_1292262873$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1292262873$dialogs() {
        return lambda$1292262873;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$2143907042$dialogs() {
        return lambda$2143907042;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2143907042$lambda$0(BoxScope DialogButtonNo, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonNo, "$this$DialogButtonNo");
        ComposerKt.sourceInformation(composer, "C87@3174L10,87@3147L85:CacheUpdateDialog.kt#as3uag");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2143907042, i, -1, "com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$CacheUpdateDialogKt.lambda$2143907042.<anonymous> (CacheUpdateDialog.kt:87)");
            }
            TextKt.m2712TextNvy7gAk("ОТМЕНА", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1292262873$lambda$0(BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C93@3375L10,93@3348L88:CacheUpdateDialog.kt#as3uag");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1292262873, i, -1, "com.miami.game.feature.download.dialog.ui.download.ComposableSingletons$CacheUpdateDialogKt.lambda$1292262873.<anonymous> (CacheUpdateDialog.kt:93)");
            }
            TextKt.m2712TextNvy7gAk("ЗАГРУЗИТЬ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
