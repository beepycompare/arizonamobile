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
import com.miami.game.core.drawable.resources.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerTopBar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$ServerTopBarKt {
    public static final ComposableSingletons$ServerTopBarKt INSTANCE = new ComposableSingletons$ServerTopBarKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$562847262 = ComposableLambdaKt.composableLambdaInstance(562847262, false, new Function3() { // from class: com.miami.game.feature.select.server.ui.compose.ComposableSingletons$ServerTopBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_562847262$lambda$0;
            lambda_562847262$lambda$0 = ComposableSingletons$ServerTopBarKt.lambda_562847262$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_562847262$lambda$0;
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$562847262$select_server_release_web() {
        return lambda$562847262;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_562847262$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C50@1864L84,49@1833L290:ServerTopBar.kt#2ojkxh");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(562847262, i, -1, "com.miami.game.feature.select.server.ui.compose.ComposableSingletons$ServerTopBarKt.lambda$562847262.<anonymous> (ServerTopBar.kt:49)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_back_launcher, composer, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(72)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
