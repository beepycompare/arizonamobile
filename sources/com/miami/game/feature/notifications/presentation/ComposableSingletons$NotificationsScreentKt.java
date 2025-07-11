package com.miami.game.feature.notifications.presentation;

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
/* compiled from: NotificationsScreent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComposableSingletons$NotificationsScreentKt {
    public static final ComposableSingletons$NotificationsScreentKt INSTANCE = new ComposableSingletons$NotificationsScreentKt();

    /* renamed from: lambda$-556808038  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f83lambda$556808038 = ComposableLambdaKt.composableLambdaInstance(-556808038, false, new Function3() { // from class: com.miami.game.feature.notifications.presentation.ComposableSingletons$NotificationsScreentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__556808038$lambda$0;
            lambda__556808038$lambda$0 = ComposableSingletons$NotificationsScreentKt.lambda__556808038$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__556808038$lambda$0;
        }
    });

    /* renamed from: getLambda$-556808038$notifications_release_web  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m8397getLambda$556808038$notifications_release_web() {
        return f83lambda$556808038;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__556808038$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C135@5180L84,134@5149L290:NotificationsScreent.kt#21zkme");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-556808038, i, -1, "com.miami.game.feature.notifications.presentation.ComposableSingletons$NotificationsScreentKt.lambda$-556808038.<anonymous> (NotificationsScreent.kt:134)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.btn_back_launcher, composer, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(72)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
