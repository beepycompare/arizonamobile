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
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$DialogCloseButtonKt {
    public static final ComposableSingletons$DialogCloseButtonKt INSTANCE = new ComposableSingletons$DialogCloseButtonKt();

    /* renamed from: lambda$-1894286437  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f70lambda$1894286437 = ComposableLambdaKt.composableLambdaInstance(-1894286437, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.core.design.system.component.button.ComposableSingletons$DialogCloseButtonKt$lambda$-1894286437$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope ScalingButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
            ComposerKt.sourceInformation(composer, "C46@1696L38,42@1564L219:DialogCloseButton.kt#x0o0f5");
            if ((i & 6) == 0) {
                i |= composer.changed(ScalingButton) ? 4 : 2;
            }
            if ((i & 19) != 18 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1894286437, i, -1, "com.miami.game.core.design.system.component.button.ComposableSingletons$DialogCloseButtonKt.lambda$-1894286437.<anonymous> (DialogCloseButton.kt:42)");
                }
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_close, composer, 0), (String) null, ScalingButton.align(SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(16)), Alignment.Companion.getCenter()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 48, (int) MenuKt.InTransitionDuration);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda$-1894286437$design_system_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8308getLambda$1894286437$design_system_release_web() {
        return f70lambda$1894286437;
    }
}
