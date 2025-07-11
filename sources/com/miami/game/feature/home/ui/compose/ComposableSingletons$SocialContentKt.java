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
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$SocialContentKt {
    public static final ComposableSingletons$SocialContentKt INSTANCE = new ComposableSingletons$SocialContentKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$1688114711 = ComposableLambdaKt.composableLambdaInstance(1688114711, false, new Function3() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1688114711$lambda$0;
            lambda_1688114711$lambda$0 = ComposableSingletons$SocialContentKt.lambda_1688114711$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1688114711$lambda$0;
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$2011919310 = ComposableLambdaKt.composableLambdaInstance(2011919310, false, new Function3() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_2011919310$lambda$1;
            lambda_2011919310$lambda$1 = ComposableSingletons$SocialContentKt.lambda_2011919310$lambda$1((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_2011919310$lambda$1;
        }
    });

    /* renamed from: lambda$-2110633905  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f82lambda$2110633905 = ComposableLambdaKt.composableLambdaInstance(-2110633905, false, new Function3() { // from class: com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__2110633905$lambda$2;
            lambda__2110633905$lambda$2 = ComposableSingletons$SocialContentKt.lambda__2110633905$lambda$2((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__2110633905$lambda$2;
        }
    });

    /* renamed from: getLambda$-2110633905$home_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8386getLambda$2110633905$home_release_web() {
        return f82lambda$2110633905;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$1688114711$home_release_web() {
        return lambda$1688114711;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$2011919310$home_release_web() {
        return lambda$2011919310;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1688114711$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C26@936L14:SocialContent.kt#dswm0d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1688114711, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt.lambda$1688114711.<anonymous> (SocialContent.kt:26)");
            }
            ImagesKt.DiscordImage(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2011919310$lambda$1(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C31@1071L15:SocialContent.kt#dswm0d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2011919310, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt.lambda$2011919310.<anonymous> (SocialContent.kt:31)");
            }
            ImagesKt.TelegramImage(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2110633905$lambda$2(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C36@1207L9:SocialContent.kt#dswm0d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2110633905, i, -1, "com.miami.game.feature.home.ui.compose.ComposableSingletons$SocialContentKt.lambda$-2110633905.<anonymous> (SocialContent.kt:36)");
            }
            ImagesKt.VkImage(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
