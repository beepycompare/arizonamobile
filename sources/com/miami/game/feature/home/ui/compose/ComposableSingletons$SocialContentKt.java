package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SocialContent.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$SocialContentKt {
    public static final ComposableSingletons$SocialContentKt INSTANCE = new ComposableSingletons$SocialContentKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1688114711 = ComposableLambdaKt.composableLambdaInstance(1688114711, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt$lambda$1688114711$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope ScalingButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
            ComposerKt.sourceInformation(composer, "C26@936L14:SocialContent.kt#dswm0d");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1688114711, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt.lambda$1688114711.<anonymous> (SocialContent.kt:26)");
                }
                ImagesKt.DiscordImage(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$2011919310 = ComposableLambdaKt.composableLambdaInstance(2011919310, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt$lambda$2011919310$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope ScalingButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
            ComposerKt.sourceInformation(composer, "C31@1071L15:SocialContent.kt#dswm0d");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2011919310, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt.lambda$2011919310.<anonymous> (SocialContent.kt:31)");
                }
                ImagesKt.TelegramImage(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda$-2110633905  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f82lambda$2110633905 = ComposableLambdaKt.composableLambdaInstance(-2110633905, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt$lambda$-2110633905$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope ScalingButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
            ComposerKt.sourceInformation(composer, "C36@1207L9:SocialContent.kt#dswm0d");
            if ((i & 17) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2110633905, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt.lambda$-2110633905.<anonymous> (SocialContent.kt:36)");
                }
                ImagesKt.VkImage(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda$-2110633905$home_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8366getLambda$2110633905$home_release_web() {
        return f82lambda$2110633905;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1688114711$home_release_web() {
        return lambda$1688114711;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$2011919310$home_release_web() {
        return lambda$2011919310;
    }
}
