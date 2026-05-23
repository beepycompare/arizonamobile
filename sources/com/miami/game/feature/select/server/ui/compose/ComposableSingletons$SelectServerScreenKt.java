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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.miami.game.ui.classic.select.server.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectServerScreen.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$SelectServerScreenKt {
    public static final ComposableSingletons$SelectServerScreenKt INSTANCE = new ComposableSingletons$SelectServerScreenKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$22973248 = ComposableLambdaKt.composableLambdaInstance(22973248, false, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ComposableSingletons$SelectServerScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SelectServerScreenKt.lambda_22973248$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$22973248$select_server() {
        return lambda$22973248;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_22973248$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C151@6055L76,150@6032L227:SelectServerScreen.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(22973248, i, -1, "com.miami.game.feature.select.server.ui.compose.ComposableSingletons$SelectServerScreenKt.lambda$22973248.<anonymous> (SelectServerScreen.kt:150)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_next, composer, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(100.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
