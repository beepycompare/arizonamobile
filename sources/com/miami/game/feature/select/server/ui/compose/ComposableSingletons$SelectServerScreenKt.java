package com.miami.game.feature.select.server.ui.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.miami.game.feature.select.server.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectServerScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$SelectServerScreenKt {
    public static final ComposableSingletons$SelectServerScreenKt INSTANCE = new ComposableSingletons$SelectServerScreenKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$22973248 = ComposableLambdaKt.composableLambdaInstance(22973248, false, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ComposableSingletons$SelectServerScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_22973248$lambda$0;
            lambda_22973248$lambda$0 = ComposableSingletons$SelectServerScreenKt.lambda_22973248$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_22973248$lambda$0;
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$22973248$select_server_release_web() {
        return lambda$22973248;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_22973248$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C149@5901L73,148@5878L224:SelectServerScreen.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(22973248, i, -1, "com.miami.game.feature.select.server.ui.compose.ComposableSingletons$SelectServerScreenKt.lambda$22973248.<anonymous> (SelectServerScreen.kt:148)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_next, composer, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(100)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
