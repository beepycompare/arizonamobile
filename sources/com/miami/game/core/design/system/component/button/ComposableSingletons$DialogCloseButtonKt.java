package com.miami.game.core.design.system.component.button;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MenuKt;
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
/* compiled from: DialogCloseButton.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$DialogCloseButtonKt {
    public static final ComposableSingletons$DialogCloseButtonKt INSTANCE = new ComposableSingletons$DialogCloseButtonKt();

    /* renamed from: lambda$-1894286437  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f70lambda$1894286437 = ComposableLambdaKt.composableLambdaInstance(-1894286437, false, new Function3() { // from class: com.miami.game.core.design.system.component.button.ComposableSingletons$DialogCloseButtonKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1894286437$lambda$0;
            lambda__1894286437$lambda$0 = ComposableSingletons$DialogCloseButtonKt.lambda__1894286437$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1894286437$lambda$0;
        }
    });

    /* renamed from: getLambda$-1894286437$design_system_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8308getLambda$1894286437$design_system_release_web() {
        return f70lambda$1894286437;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1894286437$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C46@1696L38,42@1564L219:DialogCloseButton.kt#x0o0f5");
        if ((i & 6) == 0) {
            i |= composer.changed(ScalingButton) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1894286437, i, -1, "com.miami.game.core.design.system.component.button.ComposableSingletons$DialogCloseButtonKt.lambda$-1894286437.<anonymous> (DialogCloseButton.kt:42)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_close, composer, 0), (String) null, ScalingButton.align(SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(16)), Alignment.Companion.getCenter()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 48, (int) MenuKt.InTransitionDuration);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
