package com.miami.game.feature.notifications.presentation;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.ts.TsExtractor;
import coil3.compose.AsyncImagePainter;
import coil3.compose.SubcomposeAsyncImageScope;
import com.miami.game.core.design.system.component.other.AnimatedLoadingKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NotificationItem.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$NotificationItemKt {
    public static final ComposableSingletons$NotificationItemKt INSTANCE = new ComposableSingletons$NotificationItemKt();

    /* renamed from: lambda$-458006129  reason: not valid java name */
    private static Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> f63lambda$458006129 = ComposableLambdaKt.composableLambdaInstance(-458006129, false, new Function4() { // from class: com.miami.game.feature.notifications.presentation.ComposableSingletons$NotificationItemKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$NotificationItemKt.lambda__458006129$lambda$0((SubcomposeAsyncImageScope) obj, (AsyncImagePainter.State.Loading) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });
    private static Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> lambda$968944409 = ComposableLambdaKt.composableLambdaInstance(968944409, false, new Function4() { // from class: com.miami.game.feature.notifications.presentation.ComposableSingletons$NotificationItemKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$NotificationItemKt.lambda_968944409$lambda$0((SubcomposeAsyncImageScope) obj, (AsyncImagePainter.State.Error) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* renamed from: getLambda$-458006129$notifications  reason: not valid java name */
    public final Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> m9812getLambda$458006129$notifications() {
        return f63lambda$458006129;
    }

    public final Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> getLambda$968944409$notifications() {
        return lambda$968944409;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__458006129$lambda$0(SubcomposeAsyncImageScope SubcomposeAsyncImage, AsyncImagePainter.State.Loading it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(SubcomposeAsyncImage, "$this$SubcomposeAsyncImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)62@2453L176:NotificationItem.kt#21zkme");
        if (!composer.shouldExecute((i & TsExtractor.TS_STREAM_TYPE_AC3) != 128, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-458006129, i, -1, "com.miami.game.feature.notifications.presentation.ComposableSingletons$NotificationItemKt.lambda$-458006129.<anonymous> (NotificationItem.kt:62)");
            }
            AnimatedLoadingKt.m9773AnimatedLoadinguFdPcIQ(true, Dp.m8160constructorimpl(40.0f), OffsetKt.m1009offsetVpY3zN4(Modifier.Companion, Dp.m8160constructorimpl(32.0f), Dp.m8160constructorimpl(32.0f)), composer, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_968944409$lambda$0(SubcomposeAsyncImageScope SubcomposeAsyncImage, AsyncImagePainter.State.Error it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(SubcomposeAsyncImage, "$this$SubcomposeAsyncImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)69@2698L176:NotificationItem.kt#21zkme");
        if (!composer.shouldExecute((i & TsExtractor.TS_STREAM_TYPE_AC3) != 128, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(968944409, i, -1, "com.miami.game.feature.notifications.presentation.ComposableSingletons$NotificationItemKt.lambda$968944409.<anonymous> (NotificationItem.kt:69)");
            }
            AnimatedLoadingKt.m9773AnimatedLoadinguFdPcIQ(true, Dp.m8160constructorimpl(40.0f), OffsetKt.m1009offsetVpY3zN4(Modifier.Companion, Dp.m8160constructorimpl(32.0f), Dp.m8160constructorimpl(32.0f)), composer, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
