package com.miami.game.feature.settings.ui.compose;

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
import com.miami.game.ui.classic.settings.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsBottomBar.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$SettingsBottomBarKt {
    public static final ComposableSingletons$SettingsBottomBarKt INSTANCE = new ComposableSingletons$SettingsBottomBarKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$631972942 = ComposableLambdaKt.composableLambdaInstance(631972942, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsBottomBarKt.lambda_631972942$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$124095881 = ComposableLambdaKt.composableLambdaInstance(124095881, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsBottomBarKt.lambda_124095881$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1935939771  reason: not valid java name */
    private static Function3<BoxScope, Composer, Integer, Unit> f73lambda$1935939771 = ComposableLambdaKt.composableLambdaInstance(-1935939771, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsBottomBarKt.lambda__1935939771$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1935939771$settings  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9849getLambda$1935939771$settings() {
        return f73lambda$1935939771;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$124095881$settings() {
        return lambda$124095881;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$631972942$settings() {
        return lambda$631972942;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_631972942$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C58@2127L38,57@2086L232:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(631972942, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$631972942.<anonymous> (SettingsBottomBar.kt:57)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.bug_report, composer, 0), (String) null, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_124095881$lambda$0(BoxScope ScalingButtonLong, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButtonLong, "$this$ScalingButtonLong");
        ComposerKt.sourceInformation(composer, "C65@2464L38,64@2423L232:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(124095881, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$124095881.<anonymous> (SettingsBottomBar.kt:64)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.share_logs, composer, 0), (String) null, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1935939771$lambda$0(BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C72@2784L42,71@2743L236:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1935939771, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$-1935939771.<anonymous> (SettingsBottomBar.kt:71)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.privacy_policy, composer, 0), (String) null, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
