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
import com.miami.game.feature.settings.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsBottomBar.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
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
    private static Function3<BoxScope, Composer, Integer, Unit> f145lambda$1935939771 = ComposableLambdaKt.composableLambdaInstance(-1935939771, false, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SettingsBottomBarKt.lambda__1935939771$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1935939771$settings  reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m9125getLambda$1935939771$settings() {
        return f145lambda$1935939771;
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
        ComposerKt.sourceInformation(composer, "C59@2183L38,58@2142L232:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(631972942, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$631972942.<anonymous> (SettingsBottomBar.kt:58)");
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
        ComposerKt.sourceInformation(composer, "C66@2520L38,65@2479L232:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(124095881, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$124095881.<anonymous> (SettingsBottomBar.kt:65)");
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
        ComposerKt.sourceInformation(composer, "C73@2840L42,72@2799L236:SettingsBottomBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1935939771, i, -1, "com.miami.game.feature.settings.ui.compose.ComposableSingletons$SettingsBottomBarKt.lambda$-1935939771.<anonymous> (SettingsBottomBar.kt:72)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.privacy_policy, composer, 0), (String) null, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
