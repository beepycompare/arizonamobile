package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MenuContent.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$MenuContentKt {
    public static final ComposableSingletons$MenuContentKt INSTANCE = new ComposableSingletons$MenuContentKt();

    /* renamed from: lambda$-432014182  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f80lambda$432014182 = ComposableLambdaKt.composableLambdaInstance(-432014182, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$MenuContentKt$lambda$-432014182$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope ScalingButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
            ComposerKt.sourceInformation(composer, "C42@1465L14:MenuContent.kt#dswm0d");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-432014182, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$MenuContentKt.lambda$-432014182.<anonymous> (MenuContent.kt:42)");
                }
                ImagesKt.AccountImage(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda$-989998245  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f81lambda$989998245 = ComposableLambdaKt.composableLambdaInstance(-989998245, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$MenuContentKt$lambda$-989998245$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope ScalingButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
            ComposerKt.sourceInformation(composer, "C45@1552L12:MenuContent.kt#dswm0d");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-989998245, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$MenuContentKt.lambda$-989998245.<anonymous> (MenuContent.kt:45)");
                }
                ImagesKt.ForumImage(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1483995263 = ComposableLambdaKt.composableLambdaInstance(1483995263, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$MenuContentKt$lambda$1483995263$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope ScalingButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
            ComposerKt.sourceInformation(composer, "C49@1671L15:MenuContent.kt#dswm0d");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1483995263, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$MenuContentKt.lambda$1483995263.<anonymous> (MenuContent.kt:49)");
                }
                ImagesKt.SettingsImage(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda$-432014182$home_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8364getLambda$432014182$home_release_web() {
        return f80lambda$432014182;
    }

    /* renamed from: getLambda$-989998245$home_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8365getLambda$989998245$home_release_web() {
        return f81lambda$989998245;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1483995263$home_release_web() {
        return lambda$1483995263;
    }
}
